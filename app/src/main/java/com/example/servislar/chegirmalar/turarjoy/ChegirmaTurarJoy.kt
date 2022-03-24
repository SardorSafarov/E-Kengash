package com.example.servislar.chegirmalar.turarjoy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityChegirmalarTurarjoyBinding


class ChegirmaTurarJoy : AppCompatActivity() {
    lateinit var binding: ActivityChegirmalarTurarjoyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChegirmalarTurarjoyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor= Color.WHITE
        binding.imageView10.setOnClickListener {
            finish()
        }
    }
}