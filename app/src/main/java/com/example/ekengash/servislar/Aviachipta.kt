package com.example.ekengash.servislar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityAviachiptaBinding

class Aviachipta : AppCompatActivity() {
    lateinit var binding:ActivityAviachiptaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityAviachiptaBinding.inflate(layoutInflater)
        window.statusBarColor=Color.WHITE
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aviachipta)

    }
}