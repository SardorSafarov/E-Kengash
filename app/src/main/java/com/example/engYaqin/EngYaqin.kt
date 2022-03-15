package com.example.engYaqin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityEngYaqinBinding

class EngYaqin : AppCompatActivity() {
    private lateinit var binding:ActivityEngYaqinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEngYaqinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}