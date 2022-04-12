package com.example.katrip.servislar.turarJoylar.qidirish.turarJoyHaqida

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityTurarJoyHaqidaBinding
import com.example.log.D

class TurarJoyHaqida : AppCompatActivity() {
    private lateinit var binding:ActivityTurarJoyHaqidaBinding
    private var _id=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurarJoyHaqidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        _id = intent.getStringExtra("id").toString()
        turarJoyHaqida()
            D.d(_id )
    }

    private fun turarJoyHaqida() {

    }
}