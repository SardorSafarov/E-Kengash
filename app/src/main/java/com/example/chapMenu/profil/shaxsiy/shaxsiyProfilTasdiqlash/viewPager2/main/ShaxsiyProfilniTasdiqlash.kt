package com.example.chapMenu.profil.shaxsiy.shaxsiyProfilTasdiqlash.viewPager2.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katrip.R

class ShaxsiyProfilniTasdiqlash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shaxsiy_profilni_tasdiqlash)
        statusbar()
    }
    private fun statusbar() {
        window.statusBarColor = Color.WHITE
    }
}