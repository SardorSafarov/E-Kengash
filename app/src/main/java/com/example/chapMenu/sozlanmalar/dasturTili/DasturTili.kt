package com.example.chapMenu.sozlanmalar.dasturTili

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivityDasturTiliBinding

class DasturTili : AppCompatActivity() {
    lateinit var binding:ActivityDasturTiliBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDasturTiliBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}