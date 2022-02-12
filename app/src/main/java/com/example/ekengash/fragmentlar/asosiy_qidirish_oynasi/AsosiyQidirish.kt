package com.example.ekengash.fragmentlar.asosiy_qidirish_oynasi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityAsosiyQidirishBinding

class AsosiyQidirish : AppCompatActivity() {

    lateinit var binding:ActivityAsosiyQidirishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityAsosiyQidirishBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window.statusBarColor=Color.WHITE
        ortga()

    }

    private fun ortga() {
        binding.imageButton.setOnClickListener{
            finish()
        }
    }
}