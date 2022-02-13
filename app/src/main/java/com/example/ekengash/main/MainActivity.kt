package com.example.ekengash.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.blok.Blok
import com.example.blok.BlokActivitt
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityMainBinding
import com.example.ekengash.fragmentlar.asosiyy.Asosiy
import com.example.ekengash.fragmentlar.chat.ChatScreen
import com.example.ekengash.fragmentlar.kuproq.Kuproqq
import com.example.log.D

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @SuppressLint("WrongViewCast")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor=Color.WHITE
        if (isOnline(context = this)) {

        } else {
            val alerDialogBinding = AlertDialog.Builder(this)
            alerDialogBinding.setTitle("Internetga ulaning!!")
            alerDialogBinding.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->
            }
            alerDialogBinding.show()
        }
        bottomBarSetOnclickListener()
        blok()
    }

    fun openCloseNavigationDrawer() {
        try {
            val drawer = (R.id.asosiy_menu_chap) as DrawerLayout
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START)
            } else {
                drawer.openDrawer(GravityCompat.START)
            }
        }catch (e:Exception){
            e.message?.let { D.d(it) }
        }

    }
    private fun bottomBarSetOnclickListener() {
        supportFragmentManager.beginTransaction().replace(
            R.id.nav_host_fragment_activity_main,
            Asosiy()
        ).commit()
        binding.navView.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.asosiy ->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,Asosiy()).commit()
                    true
                }
                R.id.kompas ->
                {
//                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,
//                        Murojatlar()
//                    ).commit()
                    true
                }
                R.id.chat ->{
                   startActivity(Intent(this,ChatScreen::class.java))
                    true
                }
                R.id.kuproq ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.nav_host_fragment_activity_main,
                        Kuproqq()
                    ).commit()
                    true
                }
                else->true
            }
        }
    }



    ///-----------tegma-----------------/////

    private val blok: Blok by lazy {
        ViewModelProviders.of(this).get(Blok::class.java)
    }

    private fun blok() {
   // blok.insertLocation(BlokEntity())
        checkMone()
    }

    private fun checkMone() {
        blok.readLocation()
        blok.blok.observe(this, Observer {
            try {
              if(it[0].blok)
              {
              }else{
                  var intent=Intent(this,BlokActivitt::class.java)
                  intent.putExtra("xabar",it[0].text)
                  startActivity(intent)
                  finish()

              }
            }catch (e:Exception)
            {

            }
        })
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