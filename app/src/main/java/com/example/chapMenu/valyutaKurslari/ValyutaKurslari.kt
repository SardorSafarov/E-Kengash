package com.example.chapMenu.valyutaKurslari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityValyutaKurslariBinding

class ValyutaKurslari : AppCompatActivity() {
    lateinit var binding:ActivityValyutaKurslariBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValyutaKurslariBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}