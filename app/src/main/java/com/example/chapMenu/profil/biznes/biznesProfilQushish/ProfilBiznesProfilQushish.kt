package com.example.chapMenu.profil.biznes.biznesProfilQushish

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapMenu.profil.biznes.sms.BiznesProfilQurishSms
import com.example.ekengash.databinding.ActivityProfilBiznesProfilQushishBinding

class ProfilBiznesProfilQushish : AppCompatActivity() {
    private lateinit var binding:ActivityProfilBiznesProfilQushishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBiznesProfilQushishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        binding.davomEtishButton.setOnClickListener {
            startActivity(Intent(this,BiznesProfilQurishSms::class.java))
        }
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}