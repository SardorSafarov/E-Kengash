package com.example.servislar.avtobus.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.R
import com.example.katrip.databinding.ActivityAvtobusBinding
import com.example.servislar.avtobus.chiptalarim.AvtobusChiptalarim
import com.example.servislar.avtobus.qidirish.AvtobusQidirish

class ServesAvtobus : AppCompatActivity() {
    lateinit var binding:ActivityAvtobusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAvtobusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ortgaqaytish()
        topButton()
        statsbar()
    }


    private fun topButton() {
        supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
            AvtobusQidirish()
        ).commit()
        binding.avtobusQirirish.setOnClickListener{
            topbuttonChage(true)
            supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
                AvtobusQidirish()
            ).commit()
        }
        binding.avtobusChiptalar.setOnClickListener{
            topbuttonChage(false)
            supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
                AvtobusChiptalarim()
            ).commit()
        }
    }
    fun topbuttonChage(b: Boolean)
    {
        when(b){
            true->
            {
                binding.avtobusQirirish.setBackgroundColor(Color.WHITE)
                binding.avtobusQirirish.setTextColor(Color.BLACK)
                binding.avtobusChiptalar.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.avtobusChiptalar.setTextColor(Color.parseColor("#C0C0C0"))

            }
            false->
            {
                binding.avtobusChiptalar.setBackgroundColor(Color.WHITE)
                binding.avtobusChiptalar.setTextColor(Color.BLACK)
                binding.avtobusQirirish.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.avtobusQirirish.setTextColor(Color.parseColor("#C0C0C0"))
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