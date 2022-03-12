package com.example.chapMenu.profil.profileHaqida

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityProfilHaqidaBinding

class ProfilHaqida : AppCompatActivity() {
    private lateinit var binding:ActivityProfilHaqidaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilHaqidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
        window.statusBarColor = Color.WHITE
    }
}