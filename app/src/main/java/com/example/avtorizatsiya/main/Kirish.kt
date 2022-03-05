package com.example.avtorizatsiya.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avtorizatsiya.kirsh_qismi.KirishQismi
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityKirishBinding



class Kirish : AppCompatActivity() {
    // Bislillahir rohimanir rohim


    /*------------------------------------------------Teginma-------------------------------------------------------------------------------------*/

    lateinit var binding: ActivityKirishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKirishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        teginma()
    }

    private fun teginma() {
        statusbar()
        supportFragmentManager.beginTransaction().replace(R.id.kirsh_qismidagi_fragment,KirishQismi()).commit()
    }

    private fun statusbar() {
        window.statusBarColor = Color.WHITE
    }
}