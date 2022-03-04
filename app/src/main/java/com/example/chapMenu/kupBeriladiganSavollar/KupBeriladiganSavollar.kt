package com.example.chapMenu.kupBeriladiganSavollar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityKupBeriladiganSavollarBinding

class KupBeriladiganSavollar : AppCompatActivity() {
    lateinit var binding:ActivityKupBeriladiganSavollarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKupBeriladiganSavollarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}