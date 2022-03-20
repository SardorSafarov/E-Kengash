package com.example.kirsh.surovnoma.sayohatTurlari

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ekengash.databinding.ActivitySayohatTurlariBinding

class SayohatTurlari : AppCompatActivity() {
    private lateinit var binding:ActivitySayohatTurlariBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySayohatTurlariBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
    }
}