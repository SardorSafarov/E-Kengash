package com.example.splashScreen

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.katrip.R
import com.example.kirsh.avtorizatsiya.main.Kirish
import com.example.kirsh.omBoridng.main.OnBoriding
import com.example.katrip.databinding.ActivitySplashScreenBinding
import com.example.katrip.main.MainActivity
import com.example.room.viewModel.UserViewModel
import com.example.til.LanguachHelper
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
        binding.apply {
            button.setOnClickListener{
                LanguachHelper.setLocale(context = applicationContext, "en").resources
                textView8.setText(R.string.til)
            }
            button2.setOnClickListener{
                textView8.setText(R.string.til)
                LanguachHelper.setLocale(context = applicationContext, "ru").resources
            }
        }
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


    }




    private fun onBordingFinish(): Boolean {
        val v1 = getSharedPreferences("onBording", Context.MODE_PRIVATE)
        return v1.getBoolean("tugadi", false)
    }
}