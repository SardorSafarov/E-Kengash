package com.example.chapMenu.sozlanmalar.qurulmalar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityQurulmalarBinding

class Qurulmalar : AppCompatActivity() {
    lateinit var binding:ActivityQurulmalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQurulmalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
        window.statusBarColor = Color.WHITE
    }
}