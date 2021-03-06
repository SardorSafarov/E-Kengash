package com.example.katrip.servislar.chiptalarim.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityServesChiptalarimBinding
import com.example.katrip.servislar.chiptalarim.haqida.ChiptalarimHaqida

class ServesChiptalarim : AppCompatActivity() {
    private lateinit var binding:ActivityServesChiptalarimBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.WHITE
        binding = ActivityServesChiptalarimBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ortgaQaytish()
        haqida()
    }

    private fun haqida() {
        binding.haqida.setOnClickListener {
            startActivity(Intent(this,ChiptalarimHaqida::class.java))
        }
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}