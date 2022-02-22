package com.example.ekengash.fragmentlar.chat

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import com.example.ekengash.R
import com.example.ekengash.adapter.spinner.ChatSpinnerAdapter
import com.example.ekengash.databinding.ActivityChatScreenBinding
import com.example.ekengash.entity.SpinnerEntity
import com.example.log.D

class ChatScreen : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        teginma()
        binding.spinerr.adapter = ChatSpinnerAdapter(this,list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.chat_top_menu,menu)
        return true
    }

    /*------------------------Teginma--------------------------------*/

    private fun teginma() {
        chatdanChiqish()
        topButton1()
        xabarniKuzatish()
        window.statusBarColor= Color.WHITE
    }

    lateinit var binding :ActivityChatScreenBinding
    var ovozliButton=true
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

    val list:List<SpinnerEntity> = listOf(
        SpinnerEntity(text = "Tilni sozlash   ", image = R.drawable.ic_til_icon),
        SpinnerEntity(text = "Xabarni eslatish", image = R.drawable.ic_qongroq),
        SpinnerEntity(text = "Yordam haqida   ", image = R.drawable.ic_chat_yordam_haqida)
    )


}