package com.example.servislar.ab.izlash

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityAbIzlashBinding

class ABIzlash : AppCompatActivity() {

    lateinit var binding:ActivityAbIzlashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAbIzlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor= Color.parseColor("#F3F3F3")

    }
}