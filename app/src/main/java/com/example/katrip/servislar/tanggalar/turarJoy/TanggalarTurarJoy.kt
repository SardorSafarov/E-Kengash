package com.example.katrip.servislar.tanggalar.turarJoy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityTanggalarTurarJoyBinding

class TanggalarTurarJoy : AppCompatActivity() {
    private lateinit var binding:ActivityTanggalarTurarJoyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanggalarTurarJoyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor =Color.WHITE
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}