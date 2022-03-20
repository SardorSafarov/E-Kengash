package com.example.kirsh.surovnoma.shaharlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityShaharlarBinding

class Shaharlar : AppCompatActivity() {
    private lateinit var binding:ActivityShaharlarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityShaharlarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}