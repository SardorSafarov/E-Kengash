package com.example.ekengash.servislar.aviachipta.bootomsheet

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityQayerdanAviaBinding
import com.example.ekengash.databinding.FragmentAviaChiptalarimBinding

class QayerdanAvia : AppCompatActivity() {

    lateinit var binding: ActivityQayerdanAviaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQayerdanAviaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor= Color.WHITE
        binding.chiqish.setOnClickListener {
            finish()
        }
    }
}