package com.example.ekengash.fragmentlar.chat

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityChatScreenBinding

class ChatScreen : AppCompatActivity() {
    lateinit var binding :ActivityChatScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor= Color.WHITE
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}