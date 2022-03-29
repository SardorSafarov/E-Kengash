package com.example.servislar.taxi.taxiQidirish

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.databinding.ActivityHaydovchiQidirishBinding
import com.example.log.D

class HaydovchiQidirish : AppCompatActivity() {
    private lateinit var binding: ActivityHaydovchiQidirishBinding
    private lateinit var vaqt: String
    private lateinit var qayerga: String
    private lateinit var ga_lat: String
    private lateinit var ga_lng: String
    private lateinit var qayerdan: String
    private lateinit var dan_lat: String
    private lateinit var dan_lng: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHaydovchiQidirishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        manzilMalumotlari()
        haydovchiQidirish()
    }

    private fun haydovchiQidirish() {

    }

    private fun manzilMalumotlari() {
        vaqt = intent.getStringExtra("vaqt").toString()
        qayerga = intent.getStringExtra("qayerga").toString()
        ga_lat = intent.getStringExtra("ga_lat").toString()
        ga_lng = intent.getStringExtra("ga_lng").toString()
        qayerdan = intent.getStringExtra("qayerdan").toString()
        dan_lat = intent.getStringExtra("dan_lat").toString()
        dan_lng = intent.getStringExtra("dan_lng").toString()
    }
}