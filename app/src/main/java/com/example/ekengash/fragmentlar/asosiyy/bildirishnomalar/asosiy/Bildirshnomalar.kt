package com.example.ekengash.fragmentlar.asosiyy.bildirishnomalar.asosiy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityBildirshnomalarBinding
import com.example.ekengash.fragmentlar.asosiyy.bildirishnomalar.utkazmalar.Utkazmalar

class Bildirshnomalar : AppCompatActivity() {

    lateinit var biding:ActivityBildirshnomalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityBildirshnomalarBinding.inflate(layoutInflater)
        setContentView(biding.root)
        window.statusBarColor = Color.WHITE
        biding.bildishnomaUtkazmalar.setOnClickListener {
            startActivity(Intent(this,Utkazmalar::class.java))
        }
        biding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}