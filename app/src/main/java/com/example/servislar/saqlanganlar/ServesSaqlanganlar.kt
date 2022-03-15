package com.example.servislar.saqlanganlar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityServesChiptalarimBinding
import com.example.ekengash.databinding.ActivityServesSaqlanganlarBinding

class ServesSaqlanganlar : AppCompatActivity() {
    private lateinit var binding: ActivityServesSaqlanganlarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServesSaqlanganlarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teginma()
    }

    private fun teginma() {
        ortgaQaytish()
        statusBar()
    }
    /*=======================Teginma===============================*/
    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}