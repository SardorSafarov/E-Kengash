package com.example.chapMenu.valyutaKurslari.qidirsh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityValyutaQidirishBinding

class ValyutaQidirish : AppCompatActivity() {
    private lateinit var binding:ActivityValyutaQidirishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValyutaQidirishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}