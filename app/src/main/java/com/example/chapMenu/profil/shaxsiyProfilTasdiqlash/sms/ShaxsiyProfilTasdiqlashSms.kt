package com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.sms

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.chapMenu.profil.main.Profil
import com.example.katrip.R
import com.example.katrip.databinding.ActivityShaxsiyProfilTasdiqlashSmsBinding
import com.example.katrip.databinding.AlertDiaolgSmsTasdiqlashBinding

class ShaxsiyProfilTasdiqlashSms : AppCompatActivity() {
    private lateinit var binding:ActivityShaxsiyProfilTasdiqlashSmsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShaxsiyProfilTasdiqlashSmsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        davomEtish()
        window.statusBarColor = Color.WHITE
    }

    private fun davomEtish() {
        binding.davomEtishButton.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            val view = LayoutInflater.from(this).inflate(R.layout.alert_diaolg_sms_tasdiqlash,null)
            alertDialog.setView(view)
            alertDialog.show()
            val bind = AlertDiaolgSmsTasdiqlashBinding.bind(view)
            bind.profilBoshSahifagaQaytish.setOnClickListener {
                startActivity(Intent(this,Profil::class.java))
                finish()
            }
        }
    }
}