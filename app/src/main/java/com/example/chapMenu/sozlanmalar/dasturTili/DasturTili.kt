package com.example.chapMenu.sozlanmalar.dasturTili

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityDasturTiliBinding

class DasturTili : AppCompatActivity() {
    lateinit var binding:ActivityDasturTiliBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDasturTiliBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}