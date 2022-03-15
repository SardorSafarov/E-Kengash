package com.example.servislar.chiptalarim

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityServesChiptalarimBinding

class ServesChiptalarim : AppCompatActivity() {
    private lateinit var binding:ActivityServesChiptalarimBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.WHITE
        binding = ActivityServesChiptalarimBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ortgaQaytish()
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}