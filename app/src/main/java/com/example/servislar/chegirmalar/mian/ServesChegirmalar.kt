package com.example.servislar.chegirmalar.mian

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityServesChegirmalarBinding
import com.example.asosiyQidirishOynasi.AsosiyQidirish
import com.example.servislar.chegirmalar.transport.ChegirmalarTransport
import com.example.servislar.chegirmalar.turarjoy.ChegirmaTurarJoy
import com.example.servislar.chegirmalar.turpaket.ChegirmalarTurpaket

class ServesChegirmalar : AppCompatActivity() {

    lateinit var binding: ActivityServesChegirmalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServesChegirmalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBar()
        ortgaQaytish()
        qidirish()
        turarJoy()
        turPaket()
        transport()

    }

    private fun transport() {
        binding.transportlar.setOnClickListener {
            startActivity(Intent(this, ChegirmalarTransport::class.java))
        }
    }

    private fun turPaket() {
        binding.turPaketlar.setOnClickListener {
            startActivity(Intent(this, ChegirmalarTurpaket::class.java))
        }
    }

    private fun turarJoy() {
        binding.turarJoy.setOnClickListener {
            startActivity(Intent(this, ChegirmaTurarJoy::class.java))
        }
    }

    private fun qidirish() {
        binding.qidirsh.setOnClickListener {
            startActivity(Intent(this, AsosiyQidirish::class.java))
        }
    }

    private fun ortgaQaytish() {
        binding.imageView10.setOnClickListener {
            finish()
        }
    }

    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }
}