package com.example.kirsh.avtorizatsiya.main

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kirsh.avtorizatsiya.kirshQismi.KirishQismi
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityKirishBinding


class Kirish : AppCompatActivity() {
    // Bislillahir rohimanir rohim
    private lateinit var binding: ActivityKirishBinding

    /*------------------------------------------------Teginma-------------------------------------------------------------------------------------*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKirishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        teginma()
    }

    private fun teginma() {
        statusbar()
        supportFragmentManager.beginTransaction()
            .replace(R.id.kirsh_qismidagi_fragment, KirishQismi()).commit()
    }

    private fun statusbar() {
        window.statusBarColor = Color.WHITE
    }
}