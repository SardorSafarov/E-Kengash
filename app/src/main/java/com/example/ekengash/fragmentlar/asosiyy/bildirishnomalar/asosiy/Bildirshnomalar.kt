package com.example.ekengash.fragmentlar.asosiyy.bildirishnomalar.asosiy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityBildirshnomalarBinding
import com.example.ekengash.fragmentlar.asosiyy.bildirishnomalar.utkazmalar.Utkazmalar
import com.example.servislar.avtobus.chiptalarim.AvtobusChiptalarim
import com.example.servislar.avtobus.qidirish.AvtobusQidirish

class Bildirshnomalar : AppCompatActivity() {

    lateinit var binding:ActivityBildirshnomalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBildirshnomalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE

        binding.orqagaQaytish.setOnClickListener {
            finish()
        }

        topButton()
    }
    private fun topButton() {

        binding.bildirishnomaYanggiliklar.setOnClickListener{
            topbuttonChage(true)
//            supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
//                AvtobusQidirish()
//            ).commit()
        }
        binding.bildirishnomaShaxsiXabarlar.setOnClickListener{
            topbuttonChage(false)
//            supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
//                AvtobusChiptalarim()
//            ).commit()
        }
    }
    fun topbuttonChage(b: Boolean)
    {
        when(b){
            true->
            {
                binding.bildirishnomaYanggiliklar.setBackgroundColor(Color.WHITE)
                binding.bildirishnomaYanggiliklar.setTextColor(Color.BLACK)
                binding.bildirishnomaShaxsiXabarlar.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.bildirishnomaShaxsiXabarlar.setTextColor(Color.parseColor("#C0C0C0"))

            }
            false->
            {
                binding.bildirishnomaShaxsiXabarlar.setBackgroundColor(Color.WHITE)
                binding.bildirishnomaShaxsiXabarlar.setTextColor(Color.BLACK)
                binding.bildirishnomaYanggiliklar.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.bildirishnomaYanggiliklar.setTextColor(Color.parseColor("#C0C0C0"))
            }
        }

    }
}