package com.example.chapMenu.sozlanmalar.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapMenu.sozlanmalar.bildirishnoma.SozlanmalarBildishnomalar
import com.example.chapMenu.sozlanmalar.dasturTili.DasturTili
import com.example.chapMenu.sozlanmalar.ilovaHaqida.IlovaHaqida
import com.example.chapMenu.sozlanmalar.qurulmalar.Qurulmalar
import com.example.katrip.databinding.ActivitySozlanmalarBinding

class Sozlanmalar : AppCompatActivity() {
    lateinit var binding:ActivitySozlanmalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySozlanmalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
     //   shaxsiyMalumotlar()
        bildirishnomalar()
        dasturTili()
        qurulmalar()
        ilovaHaqida()
    }

    private fun ilovaHaqida() {
        binding.sozlanmalarIlovaHaqida.setOnClickListener {
            startActivity(Intent(this,IlovaHaqida::class.java))
        }
    }

    private fun qurulmalar() {
        binding.sozlanmalarQurulmalar.setOnClickListener {
            startActivity(Intent(this,Qurulmalar::class.java))
        }
    }

    private fun dasturTili() {
        binding.sozlanmalarDasturTili.setOnClickListener {
            startActivity(Intent(this,DasturTili::class.java))
        }
    }

    private fun bildirishnomalar() {
        binding.sozlanmalarBildirishnomalar.setOnClickListener {
            startActivity(Intent(this,SozlanmalarBildishnomalar::class.java))
        }
    }

//    private fun shaxsiyMalumotlar() {
//        binding.sozlanmalarShaxsiyMalumotlar.setOnClickListener {
//            startActivity(Intent(this,ShaxsiyMalumotlar::class.java))
//        }
//    }
}