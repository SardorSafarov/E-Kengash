package com.example.ekengash.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
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
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.blok.Blok
import com.example.blok.BlokActivitt
import com.example.chapMenu.kupBeriladiganSavollar.main.KupBeriladiganSavollar
import com.example.chapMenu.offerta.Offerta
import com.example.chapMenu.profil.main.Profil
import com.example.chapMenu.sozlanmalar.main.Sozlanmalar
import com.example.chapMenu.valyutaKurslari.main.ValyutaKurslari
import com.example.constants.Constants.TEL
import com.example.constants.Constants.TOKEN
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityMainBinding
import com.example.ekengash.databinding.ChapMenuBinding
import com.example.ekengash.fragmentlar.asosiyy.main.Asosiy
import com.example.ekengash.fragmentlar.chat.main.Chat
import com.example.ekengash.fragmentlar.explore.main.Explore
import com.example.ekengash.fragmentlar.kuproq.main.Kuproqq
import com.example.log.D
import com.example.network.repository.kupBeriladiganSavollar.KupBeriladiganSavollarRepository
import com.example.network.viewModelFactory.kupBeriladiganSavollar.KupBeriladiganSavollarViewModelFactory
import com.example.network.viewmodel.kupBeriladiganSavollar.KupBeriladiganSavollarViewModel
import com.example.room.viewModel.UserViewModel
import com.example.splashScreen.SplashScreen
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()
    private var drawerLayout: DrawerLayout? = null
    private var toggle: ActionBarDrawerToggle? = null
    private var toolbar: Toolbar? = null



    @SuppressLint("WrongViewCast")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        teginma()
    }


    ///==============================Tegma===============================================================/////


    @RequiresApi(Build.VERSION_CODES.M)
    private fun teginma() {
        iternetniTekshirish()
        bottomBarSetOnclickListener()
        blok()
        statusBar()
        chapMenu()
        foydalanuvchiHaqidaMalumotlar()
        logOut()
        binding.asosiyMenuChap.setNavigationItemSelectedListener(this)
    }

    private fun foydalanuvchiHaqidaMalumotlar() {
        val bind =
            ChapMenuBinding.bind(binding.asosiyMenuChap.inflateHeaderView(R.layout.chap_menu))
        userViewModel.readUser.observe(this, Observer {
            try {
                TOKEN = it.get(0).token.toString()
                TEL=it.get(0).phone
                D.d("token $TOKEN")
                bind.foydalanuvchiIsm.setText(it.get(0).full_name)
                bind.foydalanuvchiTel.setText(it.get(0).phone)
            } catch (e: Exception) {
                D.d("MainActivity readuser")
            }
        })

        bind.foydalanuvchiRasmi.setOnClickListener {
            startActivity(Intent(this, Profil::class.java))
            val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
            drawer.closeDrawer(GravityCompat.START)
        }
        bind.foydalanuvchiniTasdiqlash.setOnClickListener {
            startActivity(Intent(this, Profil::class.java))
            val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
            drawer.closeDrawer(GravityCompat.START)
        }
    }



    /*=========================Chap menu itemclick==============================*/
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.chap_menu_valuta_kursi -> {
                startActivity(Intent(this, ValyutaKurslari::class.java))
            }
            R.id.chap_menu_kup_savol -> {
                startActivity(Intent(this, KupBeriladiganSavollar::class.java))
            }
            R.id.chap_menu_sozlanma -> {
                startActivity(Intent(this, Sozlanmalar::class.java))
            }
            R.id.chap_menu_offerta -> {
                startActivity(Intent(this, Offerta::class.java))
            }
//            R.id.chap_menu_boglanish ->{
//                startActivity(Intent(this,Boglanish::class.java))
//            }
            R.id.chap_menu_profil -> {
                startActivity(Intent(this, Profil::class.java))
            }
            R.id.chap_menu_ilova_ulashish -> {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,
                    "Ishlab chiqaruvchi Sardor Safarov \nMurojat uchun tel:+99899 505 66 98");
                intent.type = "text/plain"
                startActivity(intent)
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
                R.id.explore -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main,
                            Explore()
                        ).commit()
                    true
                }
                R.id.chat -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main,
                            Chat()
                        ).commit()
                    //   startActivity(Intent(this, ChatScreen::class.java))
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

    private fun logOut() {
        binding.logOut.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Profildan chiqish.")
            alertDialog.setMessage("Siz ushbu profildan chiqmoqchimisiz?")
            alertDialog.setPositiveButton("Ha") { dialogInterface: DialogInterface, i: Int ->
                startActivity(Intent(this, SplashScreen::class.java))
                userViewModel.deleteToken()
                finish()
            }
            alertDialog.setNegativeButton("Yo`q") { dialogInterface: DialogInterface, i: Int -> }
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
            alerDialogBinding.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int -> }
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

}