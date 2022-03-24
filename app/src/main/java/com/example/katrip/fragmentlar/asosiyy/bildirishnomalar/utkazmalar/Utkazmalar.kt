package com.example.katrip.fragmentlar.asosiyy.bildirishnomalar.utkazmalar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityUtkazmalarBinding

class Utkazmalar : AppCompatActivity() {

    private lateinit var binding:ActivityUtkazmalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUtkazmalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
        window.statusBarColor = Color.WHITE
    }
}