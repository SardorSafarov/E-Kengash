package com.example.chapMenu.profil.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapMenu.profil.biznes.main.ProfilBiznes
import com.example.chapMenu.profil.profileHaqida.ProfilHaqida
import com.example.chapMenu.profil.shaxsiy.ProfilShaxsiy
import com.example.katrip.R
import com.example.katrip.databinding.ActivityProfilBinding

class Profil : AppCompatActivity() {
    private lateinit var binding:ActivityProfilBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        topButton()
        ortgaqaytish()
        statsbar()
        ilovaHaqida()
    }

    private fun ilovaHaqida() {
        binding.profilHaqida.setOnClickListener {
        startActivity(Intent(this,ProfilHaqida::class.java))
        }
    }

    private fun topButton() {
        supportFragmentManager.beginTransaction().replace(
            R.id.profil_fragment,
            ProfilShaxsiy()
        ).commit()
        binding.profilShaxsiy.setOnClickListener{
            topbuttonChage(true)
            supportFragmentManager.beginTransaction().replace(
                R.id.profil_fragment,
                ProfilShaxsiy()
            ).commit()
        }
        binding.profilBiznes.setOnClickListener{
            topbuttonChage(false)
            supportFragmentManager.beginTransaction().replace(
                R.id.profil_fragment,
                ProfilBiznes()
            ).commit()
        }
    }

    fun topbuttonChage(b: Boolean)
    {
        when(b){
            true->
            {
                binding.profilShaxsiy.setBackgroundColor(Color.WHITE)
                binding.profilShaxsiy.setTextColor(Color.BLACK)
                binding.profilBiznes.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.profilBiznes.setTextColor(Color.parseColor("#C0C0C0"))

            }
            false->
            {
                binding.profilBiznes.setBackgroundColor(Color.WHITE)
                binding.profilBiznes.setTextColor(Color.BLACK)
                binding.profilShaxsiy.setBackgroundColor(Color.parseColor("#E8E8E8"))
                binding.profilShaxsiy.setTextColor(Color.parseColor("#C0C0C0"))
            }
        }

    }

    private fun ortgaqaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
    private fun statsbar() {
        window.statusBarColor= Color.WHITE
    }
}