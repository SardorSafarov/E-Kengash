package com.example.servislar.chegirmalar.turpaket

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityChegirmalarTurpaketBinding

class ChegirmalarTurpaket : AppCompatActivity() {
    private lateinit var binding:ActivityChegirmalarTurpaketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChegirmalarTurpaketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
    }
}