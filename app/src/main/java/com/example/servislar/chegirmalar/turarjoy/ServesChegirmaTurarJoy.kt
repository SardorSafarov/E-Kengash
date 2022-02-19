package com.example.servislar.chegirmalar.turarjoy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityServesChegirmalarTurarjoyBinding


class ServesChegirmaTurarJoy : AppCompatActivity() {
    lateinit var binding:ActivityServesChegirmalarTurarjoyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityServesChegirmalarTurarjoyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor= Color.WHITE
        binding.imageView10.setOnClickListener {
            finish()
        }
    }
}