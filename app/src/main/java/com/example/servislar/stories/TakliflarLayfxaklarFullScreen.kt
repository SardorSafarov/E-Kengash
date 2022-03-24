package com.example.servislar.stories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.katrip.databinding.ActivityTakliflarLayfxaklarFullScreenBinding

class TakliflarLayfxaklarFullScreen : AppCompatActivity() {
    private lateinit var binding:ActivityTakliflarLayfxaklarFullScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTakliflarLayfxaklarFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
         Glide.with(this).load(intent.getStringExtra("image")).into(binding.image)
    }
}