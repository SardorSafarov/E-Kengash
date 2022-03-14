package com.example.ekengash.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.avtorizatsiya.main.Kirish
import com.example.blok.Blok
import com.example.blok.BlokActivitt
import com.example.chapMenu.boglanish.Boglanish
import com.example.chapMenu.kupBeriladiganSavollar.KupBeriladiganSavollar
import com.example.chapMenu.offerta.Offerta
import com.example.chapMenu.profil.main.Profil
import com.example.chapMenu.sozlanmalar.main.Sozlanmalar
import com.example.chapMenu.valyutaKurslari.ValyutaKurslari
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityMainBinding
import com.example.ekengash.fragmentlar.asosiyy.main.Asosiy
import com.example.ekengash.fragmentlar.chat.ChatScreen
import com.example.ekengash.fragmentlar.kuproq.Kuproqq
import com.example.log.D
import com.example.room.viewModel.TokenViewModel
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    private val tokenViewModel: TokenViewModel by viewModels()


    private var PERMISSIONS: Array<String> = arrayOf(
        Manifest.permission.CAMERA
    )

    @SuppressLint("WrongViewCast")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        teginma()
        binding.asosiyMenuChap.setNavigationItemSelectedListener(this)
    }




    /*=========================Chap menu itemclick==============================*/
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id)
        {
            R.id.chap_menu_valuta_kursi->{
                startActivity(Intent(this,ValyutaKurslari::class.java))
            }
            R.id.chap_menu_kup_savol ->{
                startActivity(Intent(this,KupBeriladiganSavollar::class.java))
            }
            R.id.chap_menu_sozlanma ->{
                startActivity(Intent(this,Sozlanmalar::class.java))
            }
            R.id.chap_menu_offerta ->{
                startActivity(Intent(this,Offerta::class.java))
            }
//            R.id.chap_menu_boglanish ->{
//                startActivity(Intent(this,Boglanish::class.java))
//            }
            R.id.chap_menu_profil ->{
                startActivity(Intent(this, Profil::class.java))
            }
        }
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }




    private fun bottomBarSetOnclickListener() {
        supportFragmentManager.beginTransaction().replace(
            R.id.nav_host_fragment_activity_main,
            Asosiy()
        ).commit()
        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.asosiy -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, Asosiy()).commit()
                    true
                }
                R.id.kompas -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,
//                        Murojatlar()
//                    ).commit()
                    true
                }
                R.id.chat -> {
                    startActivity(Intent(this, ChatScreen::class.java))
                    true
                }
                R.id.kuproq -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.nav_host_fragment_activity_main,
                        Kuproqq()
                    ).commit()
                    true
                }
                else -> true
            }
        }
    }


    ///-------------------Tegma-----------------------------/////

    private var drawerLayout: DrawerLayout? = null
    private var toggle: ActionBarDrawerToggle? = null
    private var toolbar: Toolbar? = null

    @RequiresApi(Build.VERSION_CODES.M)
    private fun teginma() {
        iternetniTekshirish()
        bottomBarSetOnclickListener()
        blok()
        statusBar()
        chapMenu()
      //  chackPerimition()
        logOut()
    }

    private fun logOut() {
        binding.logOut.setOnClickListener{
           val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Profildan chiqish.")
            alertDialog.setMessage("Siz ushbu profildan chiqmoqchimisiz?")
            alertDialog.setPositiveButton("Ha"){ dialogInterface: DialogInterface, i: Int ->
                tokenViewModel.deleteToken()
                startActivity(Intent(this, Kirish::class.java))
                finish()
            }
            alertDialog.setNegativeButton("Yo`q"){ dialogInterface: DialogInterface, i: Int -> }
            alertDialog.show()
        }
    }

    private fun chapMenu() {
        drawerLayout = binding.drawerLayout
        toolbar = binding.toolbarMain
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.app_name, androidx.appcompat.R.string.abc_menu_alt_shortcut_label)
        drawerLayout!!.addDrawerListener(toggle!!)
        toggle!!.syncState()
    }

    private val blok: Blok by lazy {
        ViewModelProviders.of(this).get(Blok::class.java)
    }

    private fun blok() {
        checkMone()
    }

    private fun checkMone() {
        blok.readLocation()
        blok.blok.observe(this, Observer {
            try {
                if (it[0].blok) {
                } else {
                    var intent = Intent(this, BlokActivitt::class.java)
                    intent.putExtra("xabar", it[0].text)
                    startActivity(intent)
                    finish()

                }
            } catch (e: Exception) {

            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun iternetniTekshirish() {
        if (isOnline(context = this)) {

        } else {
            val alerDialogBinding = AlertDialog.Builder(this)
            alerDialogBinding.setTitle("Internetga ulaning.")
            alerDialogBinding.setMessage("Tarmoqni tekshiring!!")
            alerDialogBinding.setCancelable(false)
            alerDialogBinding.show()
        }
    }



    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }



    /*---------------Ruxsat berish-------------------*/
    private fun chackPerimition() {
        if (!hasPermissions(this, *PERMISSIONS)) {

            ActivityCompat.requestPermissions(this,PERMISSIONS,1);
        }
    }
    private fun hasPermissions(context: Context?, vararg PERMISSIONS: String): Boolean {
        if (context != null && PERMISSIONS != null) {
            for (permission in PERMISSIONS) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        permission
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        }
    }

}