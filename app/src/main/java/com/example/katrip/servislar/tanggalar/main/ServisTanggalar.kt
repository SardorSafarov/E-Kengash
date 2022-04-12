package com.example.katrip.servislar.tanggalar.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.R
import com.example.katrip.databinding.ActivityTanggalarBinding
import com.example.asosiyQidirishOynasi.AsosiyQidirish
import com.example.katrip.servislar.tanggalar.tanggalardanFoydalanish.TanggalardanFoydalanish
import com.example.katrip.servislar.tanggalar.tarixi.TangalarTarixi

class ServisTanggalar : AppCompatActivity() {
    private lateinit var binding:ActivityTanggalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanggalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        teginma()

    }

    private fun teginma() {
        topButton()
        ortgaqaytish()
        statsbar()
        qidirish()
    }

    /*=================Teginma=========================*/
    private fun qidirish() {
        binding.qidirsh.setOnClickListener {
            startActivity(Intent(this,AsosiyQidirish::class.java))
        }
    }


    private fun topButton() {
        supportFragmentManager.beginTransaction().replace(
            R.id.tanggalar_fragment,
            TanggalardanFoydalanish()
        ).commit()
        binding.aviaQirirish.setOnClickListener{
            binding.aviaQirirish.setBackgroundResource(R.drawable.tanggalar_button_radius)
            topbuttonChage(true)
            supportFragmentManager.beginTransaction().replace(
                R.id.tanggalar_fragment,
                TanggalardanFoydalanish()
            ).commit()
        }
        binding.aviaChiptalar.setOnClickListener{
            topbuttonChage(false)
            supportFragmentManager.beginTransaction().replace(
                R.id.tanggalar_fragment,
                TangalarTarixi()
            ).commit()
        }
    }
    fun topbuttonChage(b: Boolean)
    {
        when(b){
            true->
            {

                binding.tanggaText.setTextColor(Color.BLACK)
                binding.aviaChiptalar.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.aviaChiptalar.setTextColor(Color.parseColor("#C0C0C0"))

            }
            false->
            {
                binding.aviaChiptalar.setBackgroundColor(Color.WHITE)
                binding.aviaChiptalar.setTextColor(Color.BLACK)
                binding.aviaQirirish.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.tanggaText .setTextColor(Color.parseColor("#C0C0C0"))
            }
        }

    }
    private fun ortgaqaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
    private fun statsbar() {
        window.statusBarColor= Color.WHITE
    }
}