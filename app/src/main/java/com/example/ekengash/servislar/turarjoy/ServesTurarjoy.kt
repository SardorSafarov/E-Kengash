package com.example.ekengash.servislar.turarjoy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityServesTurarjoyBinding

class ServesTurarjoy : AppCompatActivity() {
    lateinit var binding:ActivityServesTurarjoyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityServesTurarjoyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor= Color.WHITE
        binding.imageView10.setOnClickListener {
            finish()
        }
    }
}