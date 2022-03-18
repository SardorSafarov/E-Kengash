package com.example.servislar.turPaketlar.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityServesTurPaketBinding

class ServesTurPaket : AppCompatActivity() {
    private lateinit var binding:ActivityServesTurPaketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServesTurPaketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBar()
    }

    private fun statusBar() {
        window.statusBarColor = Color.parseColor("#F3F3F3")
    }
}