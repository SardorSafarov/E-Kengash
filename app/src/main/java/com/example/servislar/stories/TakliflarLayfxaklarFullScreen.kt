package com.example.servislar.stories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import com.example.katrip.R
import com.example.katrip.databinding.ActivityTakliflarLayfxaklarFullScreenBinding
import com.example.log.D

class TakliflarLayfxaklarFullScreen : AppCompatActivity() {
    private lateinit var binding: ActivityTakliflarLayfxaklarFullScreenBinding
    private var text = 2
    private var text1 = ""
    private var text2 = ""
    private var text3 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTakliflarLayfxaklarFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this).load(intent.getStringExtra("image")).into(binding.image)
        text1 = intent.getStringExtra("text1").toString()
        text2 = intent.getStringExtra("text2").toString()
        text3 = intent.getStringExtra("text3").toString()
        binding.name.setText(intent.getStringExtra("name"))
        textUzgarish()
        binding.title.setText(text1)
    }

    fun textUzgarish() {

        Handler().postDelayed({
            when (text) {
                2 -> {
                    binding.title.setText(text2)
                    text = 3
                }
                3 -> {
                    binding.title.setText(text3)
                    text = 4
                }
                4 -> {
                    finish()
                }
            }
            textUzgarish()
        }, 4000)
    }
}