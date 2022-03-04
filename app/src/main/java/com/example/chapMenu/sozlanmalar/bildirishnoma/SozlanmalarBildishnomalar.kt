package com.example.chapMenu.sozlanmalar.bildirishnoma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityBildirshnomalarBinding
import com.example.ekengash.databinding.ActivitySozlanmalarBildishnomalarBinding

class SozlanmalarBildishnomalar : AppCompatActivity() {
    lateinit var binding:ActivitySozlanmalarBildishnomalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySozlanmalarBildishnomalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}