package com.example.katrip.servislar.aviachipta.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.R
import com.example.katrip.databinding.ActivityAviachiptaBinding
import com.example.katrip.servislar.aviachipta.chiptalarim.AviaChiptalarim
import com.example.katrip.servislar.aviachipta.qidirish.AviaQidirish

class ServesAvia : AppCompatActivity() {
    lateinit var binding:ActivityAviachiptaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityAviachiptaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ortgaqaytish()
        topButton()
        statsbar()

    }



    private fun topButton() {
        supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
            AviaQidirish()
        ).commit()
        binding.aviaQirirish.setOnClickListener{
            topbuttonChage(true)
            supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
                AviaQidirish()
            ).commit()
        }
        binding.aviaChiptalar.setOnClickListener{
            topbuttonChage(false)
            supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
                AviaChiptalarim()
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
        binding.orqagaQaytishAb.setOnClickListener {
            finish()
        }
    }
    private fun statsbar() {
        window.statusBarColor=Color.parseColor("#F3F3F3")
    }
}