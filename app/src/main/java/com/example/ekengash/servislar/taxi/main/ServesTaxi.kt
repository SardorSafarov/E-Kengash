package com.example.ekengash.servislar.taxi.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityTaxiBinding
import com.example.ekengash.servislar.poyezd.chiptalarim.PoyizChiptalarim
import com.example.ekengash.servislar.poyezd.qidirish.PoyzQidirish
import com.example.ekengash.servislar.taxi.buyurtmalrim.TaxiBuyurtmalrim
import com.example.ekengash.servislar.taxi.qidirish.TaxiQidirish

class ServesTaxi : AppCompatActivity() {
    lateinit var binding:ActivityTaxiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTaxiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ortgaqaytish()
        topButton()
        statsbar()
    }
    private fun topButton() {
        supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
            TaxiQidirish()
        ).commit()
        binding.taxiQirirish.setOnClickListener{
            topbuttonChage(true)
            supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
                TaxiQidirish()
            ).commit()
        }
        binding.taxiChiptalar.setOnClickListener{
            topbuttonChage(false)
            supportFragmentManager.beginTransaction().replace(R.id.aviabeletlar_fragment,
                TaxiBuyurtmalrim()
            ).commit()
        }
    }
    fun topbuttonChage(b: Boolean)
    {
        when(b){
            true->
            {
                binding.taxiQirirish.setBackgroundColor(Color.WHITE)
                binding.taxiQirirish.setTextColor(Color.BLACK)
                binding.taxiChiptalar.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.taxiChiptalar.setTextColor(Color.parseColor("#C0C0C0"))

            }
            false->
            {
                binding.taxiChiptalar.setBackgroundColor(Color.WHITE)
                binding.taxiChiptalar.setTextColor(Color.BLACK)
                binding.taxiQirirish.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.taxiQirirish.setTextColor(Color.parseColor("#C0C0C0"))
            }
        }

    }
    private fun ortgaqaytish() {
        binding.imageView3.setOnClickListener {
            finish()
        }
    }
    private fun statsbar() {
        window.statusBarColor= Color.parseColor("#F3F3F3")
    }
}