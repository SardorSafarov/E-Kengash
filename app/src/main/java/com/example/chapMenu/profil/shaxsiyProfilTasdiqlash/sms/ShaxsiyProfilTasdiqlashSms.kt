package com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.sms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityShaxsiyProfilTasdiqlashSmsBinding

class ShaxsiyProfilTasdiqlashSms : AppCompatActivity() {
    private lateinit var binding:ActivityShaxsiyProfilTasdiqlashSmsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShaxsiyProfilTasdiqlashSmsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}