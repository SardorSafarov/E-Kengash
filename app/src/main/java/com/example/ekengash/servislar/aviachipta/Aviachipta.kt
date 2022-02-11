package com.example.ekengash.servislar.aviachipta

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityAviachiptaBinding
import com.example.ekengash.servislar.aviachipta.chiptalarim.AviaChiptalarim
import com.example.ekengash.servislar.aviachipta.qidirish.AviaQidirish

class Aviachipta : AppCompatActivity() {
    lateinit var binding:ActivityAviachiptaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityAviachiptaBinding.inflate(layoutInflater)
        window.statusBarColor=Color.WHITE
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aviachipta)
        ortgaqaytish()
        topButton()
    }

    private fun topButton() {
        supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
            AviaQidirish()
        ).commit()
        binding.aviaQirirish.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
                AviaQidirish()
            ).commit()
        }
        binding.aviaChiptalar.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
                AviaChiptalarim()
            ).commit()
        }
    }

    private fun ortgaqaytish() {
        binding.imageView3.setOnClickListener {
            d("sardor","kedi")
            finish()
        }
    }
}