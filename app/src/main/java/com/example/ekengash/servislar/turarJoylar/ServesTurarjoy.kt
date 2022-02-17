package com.example.ekengash.servislar.turarJoylar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityServesTurarjoy2Binding
import com.example.ekengash.servislar.aviachipta.chiptalarim.AviaChiptalarim
import com.example.ekengash.servislar.aviachipta.qidirish.AviaQidirish
import com.example.ekengash.servislar.turarJoylar.buyurtmalar.TurarJoyBuyurmalar
import com.example.ekengash.servislar.turarJoylar.qidirish.TurarJoyQidirish

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
        binding.imageView3.setOnClickListener {
            finish()
        }
    }
    private fun statsbar() {
        window.statusBarColor= Color.parseColor("#F3F3F3")
    }
}