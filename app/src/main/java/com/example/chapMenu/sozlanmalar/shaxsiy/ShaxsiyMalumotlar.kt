package com.example.chapMenu.sozlanmalar.shaxsiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityShaxsiyMalumotlarBinding

class ShaxsiyMalumotlar : AppCompatActivity() {
    lateinit var binding:ActivityShaxsiyMalumotlarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShaxsiyMalumotlarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}