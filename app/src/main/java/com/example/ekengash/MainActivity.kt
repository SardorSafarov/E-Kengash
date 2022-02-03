package com.example.ekengash

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.ekengash.databinding.ActivityMainBinding
import com.example.ekengash.fragmentlar.asosiyy.Asosiy
import com.example.ekengash.fragmentlar.chat.Chat
import com.example.ekengash.fragmentlar.kuproq.Kuproqq
import com.example.ekengash.fragmentlar.murojaatlar.Murojatlar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (isOnline(context = this)) {

        } else {
            val alerDialogBinding = AlertDialog.Builder(this)
            alerDialogBinding.setTitle("Internetga ulaning!!")
            alerDialogBinding.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->
            }
            alerDialogBinding.show()
        }
        bottomBarSetOnclickListener()
        window.statusBarColor= Color.WHITE
    }

    private fun bottomBarSetOnclickListener() {
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,
            Asosiy()
        ).commit()
        binding.navView.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.asosiy ->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,Asosiy()).commit()
                    true
                }
                R.id.murojaat->
                {
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,
                        Murojatlar()
                    ).commit()
                    true
                }
                R.id.chat->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,
                        Chat()
                    ).commit()
                    true
                }
                R.id.kuproq->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,
                        Kuproqq()
                    ).commit()
                    true
                }
                else->true
            }
        }
    }



    ///-----------tegma-----------------/////
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