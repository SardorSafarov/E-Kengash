package com.example.ekengash.fragmentlar.chat

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log.d
import androidx.core.widget.addTextChangedListener
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityChatScreenBinding
import com.example.log.D

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
        xabarniKuzatish()
    }

    private fun xabarniKuzatish() {
        binding.matinliyXabar.addTextChangedListener (object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
              when(p0.toString().length)
              {
                  0->{
                      D.d(p0.toString())
                      binding.xabarJunatish.setImageResource(R.drawable.ic_chat_mikrafon)
                  }
                  else->{
                      D.d(p0.toString())
                      binding.xabarJunatish.setImageResource(R.drawable.ic_xabar_yuborish)
                  }
              }
            }
            override fun afterTextChanged(p0: Editable?) {
            }

        })
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