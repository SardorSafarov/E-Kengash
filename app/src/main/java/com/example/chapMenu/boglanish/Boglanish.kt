package com.example.chapMenu.boglanish

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityBoglanishBinding

class Boglanish : AppCompatActivity() {

    lateinit var binding:ActivityBoglanishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoglanishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}