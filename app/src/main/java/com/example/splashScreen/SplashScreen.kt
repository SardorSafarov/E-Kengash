package com.example.splashScreen

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.avtorizatsiya.main.Kirish
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivitySplashScreenBinding
import com.example.ekengash.main.MainActivity
import com.example.room.viewModel.TokenViewModel

class SplashScreen : AppCompatActivity() {
    //*======لا اله الا الله محمد رسول الله
    private lateinit var binding:ActivitySplashScreenBinding
    private val tokenViewModel: TokenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        tokenViewModel.readToken.observe(this, Observer {
            if(it.isEmpty())
            {
                startActivity(Intent(this,Kirish::class.java))
                finish()
            }else
            {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
        })
    }
}