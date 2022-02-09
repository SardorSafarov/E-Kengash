package com.example.ekengash.fragmentlar.chat

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityChatScreenBinding

class ChatScreen : AppCompatActivity() {
    lateinit var binding :ActivityChatScreenBinding
    var ovozliButton=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor= Color.WHITE
        chatdanChiqish()
        topButton1()

    }

    private fun topButton1() {
        binding.ovozliChatButton.setOnClickListener {
           when(ovozliButton)
           {
               true->
               {
                   binding.ovozliChatButton.setImageResource(R.drawable.ic_ovozli_chat_1)
                   ovozliButton=false
               }
               else->
               {
                   binding.ovozliChatButton.setImageResource(R.drawable.ic_ovozli_chat_2)
                   ovozliButton=true
               }
           }
        }
    }

    private fun chatdanChiqish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}