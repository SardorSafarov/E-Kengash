package com.example.kirsh.surovnoma.kimBilanSayohat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityKimBilanSayohatBinding

class KimBilanSayohat : AppCompatActivity() {
    private lateinit var binding:ActivityKimBilanSayohatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKimBilanSayohatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}