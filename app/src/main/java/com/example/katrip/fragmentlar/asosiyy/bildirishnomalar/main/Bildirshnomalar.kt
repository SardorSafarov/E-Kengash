package com.example.katrip.fragmentlar.asosiyy.bildirishnomalar.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.R
import com.example.katrip.databinding.ActivityBildirshnomalarBinding
import com.example.katrip.fragmentlar.asosiyy.bildirishnomalar.yangiliklar.Yangiliklar

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
        supportFragmentManager.beginTransaction().replace(R.id.fragmen_bildirishnomalar,
            Yangiliklar()
        ).commit()
        binding.bildirishnomaYanggiliklar.setOnClickListener{
            topbuttonChage(true)
            supportFragmentManager.beginTransaction().replace(R.id.fragmen_bildirishnomalar,
                Yangiliklar()
            ).commit()
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