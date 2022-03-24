package com.example.servislar.saqlanganlar.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityServesSaqlanganlarBinding
import com.example.log.D
import com.example.servislar.saqlanganlar.haqida.SaqlanganlarHaqida

class ServesSaqlanganlar : AppCompatActivity() {
    private lateinit var binding: ActivityServesSaqlanganlarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServesSaqlanganlarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teginma()
    }

    private fun teginma() {
        ortgaQaytish()
        statusBar()
        saqlanganlarHaqida()
    }

    private fun saqlanganlarHaqida() {
        binding.haqida.setOnClickListener {
            D.d("keldiiii")
            startActivity(Intent(this, SaqlanganlarHaqida::class.java))
        }
    }

    /*=======================Teginma===============================*/
    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}