package com.example.kirsh.omBoridng.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityOnBoridingBinding

class OnBoriding : AppCompatActivity() {
    private lateinit var binding:ActivityOnBoridingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoridingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbar()
    }

    private fun statusbar() {
        window.statusBarColor = Color.WHITE
    }
}