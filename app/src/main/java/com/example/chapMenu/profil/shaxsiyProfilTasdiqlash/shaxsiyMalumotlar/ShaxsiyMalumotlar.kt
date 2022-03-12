package com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.shaxsiyMalumotlar

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.passprtMalumotlari.PassportMalumotlar
import com.example.ekengash.databinding.ActivityShaxsiyMalumotlarBinding

class ShaxsiyMalumotlar : AppCompatActivity() {
    private lateinit var binding:ActivityShaxsiyMalumotlarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShaxsiyMalumotlarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.parseColor("#F3F3F3")
        binding.davomEtishButton.setOnClickListener {
            startActivity(Intent(this,PassportMalumotlar::class.java))
        }
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}