package com.example.katrip.servislar.turarJoylar.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.R
import com.example.katrip.databinding.ActivityServesTurarjoy2Binding
import com.example.katrip.servislar.turarJoylar.buyurtmalar.TurarJoyBuyurmalar
import com.example.katrip.servislar.turarJoylar.qidirish.main.TurarJoyQidirish

class ServesTurarjoy : AppCompatActivity() {
    lateinit var binding:ActivityServesTurarjoy2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityServesTurarjoy2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        topButton()
        ortgaqaytish()
        statsbar()
    }
    private fun topButton() {
        supportFragmentManager.beginTransaction().replace(R.id.turar_joy_fragment,
            TurarJoyQidirish()
        ).commit()
        binding.turarJoyQirirish.setOnClickListener{
            topbuttonChage(true)
            supportFragmentManager.beginTransaction().replace(R.id.turar_joy_fragment,
                TurarJoyQidirish()
            ).commit()
        }
        binding.turarJoyBuyurtmalar.setOnClickListener{
            topbuttonChage(false)
            supportFragmentManager.beginTransaction().replace(R.id.turar_joy_fragment,
                TurarJoyBuyurmalar()
            ).commit()
        }
    }
    fun topbuttonChage(b: Boolean)
    {
        when(b){
            true->
            {
                binding.turarJoyQirirish.setBackgroundColor(Color.WHITE)
                binding.turarJoyQirirish.setTextColor(Color.BLACK)
                binding.turarJoyBuyurtmalar.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.turarJoyBuyurtmalar.setTextColor(Color.parseColor("#C0C0C0"))

            }
            false->
            {
                binding.turarJoyBuyurtmalar.setBackgroundColor(Color.WHITE)
                binding.turarJoyBuyurtmalar.setTextColor(Color.BLACK)
                binding.turarJoyQirirish.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.turarJoyQirirish.setTextColor(Color.parseColor("#C0C0C0"))
            }
        }

    }
    private fun ortgaqaytish() {
        binding.orqagaQaytishAb.setOnClickListener {
            finish()
        }
    }
    private fun statsbar() {
        window.statusBarColor= Color.parseColor("#F3F3F3")
    }
}