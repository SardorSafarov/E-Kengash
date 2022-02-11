package com.example.ekengash.servislar.aviachipta.bootomsheet

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityQayergaAviaBinding

class QayergaAvia : AppCompatActivity() {
    lateinit var binding:ActivityQayergaAviaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityQayergaAviaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window.statusBarColor=Color.WHITE
        binding.chiqish.setOnClickListener {
            finish()
        }
    }
}