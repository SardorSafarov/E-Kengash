package com.example.katrip.fragmentlar.asosiyy.bildirishnomalar.yangiliklar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.katrip.databinding.ActivityYangiliklarFulScreenBinding

class YangiliklarFulScreen : AppCompatActivity() {
    private lateinit var binding:ActivityYangiliklarFulScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYangiliklarFulScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        Glide.with(this).load(intent.getStringExtra("image")).into(binding.image)
        binding.apply {
            name.setText(intent.getStringExtra("name"))
            title.setText(intent.getStringExtra("title"))
        }
        ortgaQaytish()

    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}