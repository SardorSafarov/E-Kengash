package com.example.ekengash.servislar.ab

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityServesAbBinding

class ServesAB : AppCompatActivity() {

    lateinit var binding:ActivityServesAbBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityServesAbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor= Color.parseColor("#F3F3F3")

    }
}