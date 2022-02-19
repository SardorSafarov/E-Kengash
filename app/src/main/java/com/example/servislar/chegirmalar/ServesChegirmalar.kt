package com.example.servislar.chegirmalar

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityServesChegirmalarBinding
import com.example.ekengash.fragmentlar.asosiyy.asosiy_qidirish_oynasi.AsosiyQidirish
import com.example.servislar.chegirmalar.turarjoy.ServesChegirmaTurarJoy

class ServesChegirmalar : AppCompatActivity() {

    lateinit var binding:ActivityServesChegirmalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityServesChegirmalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor=Color.WHITE
        binding.imageView10.setOnClickListener {
            finish()
        }
        binding.chegirmalarTopButton1.setOnClickListener {
            startActivity(Intent(this,AsosiyQidirish::class.java))
        }
        binding.turarJoy.setOnClickListener {
            startActivity(Intent(this,ServesChegirmaTurarJoy::class.java))
        }
    }
}