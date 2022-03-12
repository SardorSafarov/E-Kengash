package com.example.servislar.tanggalar.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityTanggalarBinding
import com.example.servislar.aviachipta.chiptalarim.AviaChiptalarim
import com.example.servislar.aviachipta.qidirish.AviaQidirish
import com.example.servislar.tanggalar.tangga_1.TanggalardanFoydalanish
import com.example.servislar.tanggalar.taxi.TanggalardanTaxi

class Tanggalar : AppCompatActivity() {
    private lateinit var binding:ActivityTanggalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanggalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        topButton()
        ortgaqaytish()
        statsbar()
    }


    private fun topButton() {
        supportFragmentManager.beginTransaction().replace(
            R.id.tanggalar_fragment,
            TanggalardanFoydalanish()
        ).commit()
        binding.aviaQirirish.setOnClickListener{
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
                TanggalardanTaxi()
            ).commit()
        }
    }
    fun topbuttonChage(b: Boolean)
    {
        when(b){
            true->
            {
                binding.aviaQirirish.setBackgroundColor(Color.WHITE)
                binding.aviaQirirish.setTextColor(Color.BLACK)
                binding.aviaChiptalar.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.aviaChiptalar.setTextColor(Color.parseColor("#C0C0C0"))

            }
            false->
            {
                binding.aviaChiptalar.setBackgroundColor(Color.WHITE)
                binding.aviaChiptalar.setTextColor(Color.BLACK)
                binding.aviaQirirish.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.aviaQirirish.setTextColor(Color.parseColor("#C0C0C0"))
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