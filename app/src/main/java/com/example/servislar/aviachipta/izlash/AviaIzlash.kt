package com.example.servislar.aviachipta.izlash

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityAviaIzlashBinding

class AviaIzlash : AppCompatActivity() {
    lateinit var binding:ActivityAviaIzlashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAviaIzlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor=Color.WHITE
        ortga()
        filterlash()
    }

    private fun filterlash() {
        binding.filterButton.setOnClickListener {

        }
    }

    private fun ortga() {
        binding.imageView10.setOnClickListener {
            finish()
        }
    }
}