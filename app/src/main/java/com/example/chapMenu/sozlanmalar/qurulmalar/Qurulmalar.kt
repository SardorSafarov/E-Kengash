package com.example.chapMenu.sozlanmalar.qurulmalar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityQurulmalarBinding

class Qurulmalar : AppCompatActivity() {
    lateinit var binding:ActivityQurulmalarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQurulmalarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}