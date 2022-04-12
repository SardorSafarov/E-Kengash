package com.example.katrip.servislar.turPaketlar.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.R
import com.example.katrip.databinding.ActivityServesTurPaketBinding
import com.example.katrip.servislar.turPaketlar.qidirsh.TurPaketQidirsh
import com.example.katrip.servislar.turPaketlar.saqlanganlar.TurPaketSaqlanganlar

class ServesTurPaket : AppCompatActivity() {
    private lateinit var binding:ActivityServesTurPaketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServesTurPaketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBar()
        topButton()
        ortgaqaytish()
    }
    private fun topButton() {
        supportFragmentManager.beginTransaction().replace(
            R.id.tur_paketlar_fragment,
            TurPaketQidirsh()
        ).commit()
        binding.aviaQirirish.setOnClickListener{
            topbuttonChage(true)
            supportFragmentManager.beginTransaction().replace(
                R.id.tur_paketlar_fragment,
                TurPaketQidirsh()
            ).commit()
        }
        binding.aviaChiptalar.setOnClickListener{
            topbuttonChage(false)
            supportFragmentManager.beginTransaction().replace(
                R.id.tur_paketlar_fragment,
                TurPaketSaqlanganlar()
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
    private fun statusBar() {
        window.statusBarColor = Color.parseColor("#F3F3F3")
    }
}