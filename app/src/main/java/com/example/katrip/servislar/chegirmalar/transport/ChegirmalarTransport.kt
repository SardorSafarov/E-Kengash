package com.example.katrip.servislar.chegirmalar.transport

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityChegirmalarTransportBinding

class ChegirmalarTransport : AppCompatActivity() {
    private lateinit var binding:ActivityChegirmalarTransportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChegirmalarTransportBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
    }
}