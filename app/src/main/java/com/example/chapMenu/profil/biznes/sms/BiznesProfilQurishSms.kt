package com.example.chapMenu.profil.biznes.sms

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityBiznesProfilQurishSmsBinding

class BiznesProfilQurishSms : AppCompatActivity() {
    private lateinit var binding:ActivityBiznesProfilQurishSmsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBiznesProfilQurishSmsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }


    }
}