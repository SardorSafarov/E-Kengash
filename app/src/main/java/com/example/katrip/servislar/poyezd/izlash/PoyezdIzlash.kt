package com.example.katrip.servislar.poyezd.izlash

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityPoyezdIzlashBinding

class PoyezdIzlash : AppCompatActivity() {
    lateinit var binding:ActivityPoyezdIzlashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPoyezdIzlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor=Color.WHITE
        binding.imageView10.setOnClickListener {
            finish()
        }
    }
}