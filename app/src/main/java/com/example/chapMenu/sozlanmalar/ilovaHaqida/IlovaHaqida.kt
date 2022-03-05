package com.example.chapMenu.sozlanmalar.ilovaHaqida

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityIlovaHaqidaBinding

class IlovaHaqida : AppCompatActivity() {
    lateinit var binding:ActivityIlovaHaqidaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIlovaHaqidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}