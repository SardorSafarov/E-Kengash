package com.example.chapMenu.sozlanmalar.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivitySozlanmalarBinding

class Sozlanmalar : AppCompatActivity() {
    lateinit var binding:ActivitySozlanmalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySozlanmalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        shaxsiyMalumotlar()
        bildirishnomalar()
        dasturTili()
        qurulmalar()
        ilovaHaqida()
    }

    private fun ilovaHaqida() {

    }

    private fun qurulmalar() {

    }

    private fun dasturTili() {

    }

    private fun bildirishnomalar() {

    }

    private fun shaxsiyMalumotlar() {

    }
}