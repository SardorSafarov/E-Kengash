package com.example.ekengash.kirish

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityKirishBinding


class Kirish : AppCompatActivity() {

    lateinit var binding: ActivityKirishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityKirishBinding.inflate(layoutInflater)
        setContentView(binding.root)
            window.statusBarColor= Color.WHITE
    }
}