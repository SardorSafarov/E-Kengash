package com.example.engYaqin.haqida

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityEngYaqinBinding
import com.example.ekengash.databinding.ActivityEngYaqinHaqidaBinding

class EngYaqinHaqida : AppCompatActivity() {
    private lateinit var binding:ActivityEngYaqinHaqidaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEngYaqinHaqidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        ortgaQaytish()
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}