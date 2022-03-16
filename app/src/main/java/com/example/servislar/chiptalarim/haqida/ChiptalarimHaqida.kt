package com.example.servislar.chiptalarim.haqida

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityChatHaqidaBinding
import com.example.ekengash.databinding.ActivityChiptalarimHaqidaBinding

class ChiptalarimHaqida : AppCompatActivity() {
    private lateinit var binding:ActivityChiptalarimHaqidaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiptalarimHaqidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBar()
        ortgaQaytish()
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }

    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }
}