package com.example.servislar.saqlanganlar.haqida

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivitySaqlanganlarHaqidaBinding

class SaqlanganlarHaqida : AppCompatActivity() {
    private lateinit var binding:ActivitySaqlanganlarHaqidaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaqlanganlarHaqidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBar()
        ortgaQaytish()
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }

    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }
}