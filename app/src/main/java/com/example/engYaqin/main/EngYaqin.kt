package com.example.engYaqin.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityEngYaqinBinding
import com.example.engYaqin.haqida.EngYaqinHaqida

class EngYaqin : AppCompatActivity() {

    private lateinit var binding:ActivityEngYaqinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEngYaqinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBar()
        ortgaQaytish()
       haqida()
    }

    private fun haqida() {
        binding.engYaqinHaqida.setOnClickListener {
            startActivity(Intent(this,EngYaqinHaqida::class.java))
        }
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }

    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }
}