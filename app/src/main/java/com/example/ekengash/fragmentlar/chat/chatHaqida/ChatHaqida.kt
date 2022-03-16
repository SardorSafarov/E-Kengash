package com.example.ekengash.fragmentlar.chat.chatHaqida

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityChatHaqidaBinding

class ChatHaqida : AppCompatActivity() {
    private lateinit var binding:ActivityChatHaqidaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatHaqidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbar()
        ortgaQaytish()

    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }

    private fun statusbar() {
        window.statusBarColor = Color.WHITE
    }
}