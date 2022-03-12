package com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityProfilShaxsiyParofilTasdiqlashBinding

class ProfilShaxsiyParofilTasdiqlash : AppCompatActivity() {
    private lateinit var binding:ActivityProfilShaxsiyParofilTasdiqlashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilShaxsiyParofilTasdiqlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE

    }
}