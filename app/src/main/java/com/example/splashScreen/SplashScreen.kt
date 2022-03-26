package com.example.splashScreen

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.constants.Constants.LocalTilKey
import com.example.kirsh.avtorizatsiya.main.Kirish
import com.example.kirsh.omBoridng.main.OnBoriding
import com.example.katrip.databinding.ActivitySplashScreenBinding
import com.example.katrip.main.MainActivity
import com.example.room.viewModel.UserViewModel
import java.util.*

class SplashScreen : AppCompatActivity() {
    //*======لا اله الا الله محمد رسول الله
    private lateinit var binding: ActivitySplashScreenBinding
    private val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE

        userViewModel.readUser.observe(this, Observer {
            if (it.isEmpty()) {
                if (onBordingFinish()) {
                    startActivity(Intent(this, Kirish::class.java))
                    finish()
                } else {
                    startActivity(Intent(this, OnBoriding::class.java))
                    finish()
                }
            } else {

                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })
        val til = getSharedPreferences(LocalTilKey, MODE_PRIVATE)
        setApplicationLocale(til.getString("til","default").toString())
    }
    private fun setApplicationLocale(locale: String) {
        val resources: Resources = resources
        val dm: DisplayMetrics = resources.getDisplayMetrics()
        val config: Configuration = resources.getConfiguration()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(Locale(locale.toLowerCase()))
        } else {
            config.locale = Locale(locale.toLowerCase())
        }
        resources.updateConfiguration(config, dm)
    }
    private fun onBordingFinish(): Boolean {
        val v1 = getSharedPreferences("onBording", Context.MODE_PRIVATE)
        return v1.getBoolean("tugadi", false)
    }
}