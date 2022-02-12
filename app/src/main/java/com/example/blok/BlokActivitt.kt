package com.example.blok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityBlokActivittBinding

class BlokActivitt : AppCompatActivity() {

    lateinit var binding: ActivityBlokActivittBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlokActivittBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val xabar= intent.getStringExtra("xabar")
        binding.blokXabari.text=xabar
    }
}