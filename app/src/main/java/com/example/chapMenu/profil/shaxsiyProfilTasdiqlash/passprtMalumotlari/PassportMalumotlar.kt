package com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.passprtMalumotlari

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.yuzniScanerlash.YuzniSkanerlash
import com.example.ekengash.databinding.ActivityPassportMalumotlarBinding

class PassportMalumotlar : AppCompatActivity() {
    private lateinit var binding:ActivityPassportMalumotlarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPassportMalumotlarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.parseColor("#F3F3F3")
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
        binding.davomEtishButton.setOnClickListener {
            startActivity(Intent(this,YuzniSkanerlash::class.java))
        }
    }
}