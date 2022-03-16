package com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.shaxsiyMalumotlar

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.passprtMalumotlari.PassportMalumotlar
import com.example.ekengash.databinding.ActivityShaxsiyMalumotlarBinding

class ShaxsiyMalumotlar : AppCompatActivity() {
    private lateinit var binding:ActivityShaxsiyMalumotlarBinding
    private val validatsitaMessage="to'ldirilishi shart"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShaxsiyMalumotlarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ortgaQaytish()
        statusBar()
        davomEtish()


    }

    private fun davomEtish() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Xatolik!!")
        alertDialog.setMessage("Iltimos, sahifadagi barcha maydonlarni to'ldiring!")
        alertDialog.setPositiveButton("Tushundim"){ dialogInterface: DialogInterface, i: Int -> }
        binding.davomEtishButton.setOnClickListener {
            if(validatsiyaEditText()){
                startActivity(Intent(this,PassportMalumotlar::class.java))
            }else
            {
                alertDialog.show()
            }

        }
    }

    private fun validatsiyaEditText(): Boolean {
        binding.apply {
            if(foydalanuvchiIsmi.text?.length==0)
            {
                ismEditText1.error = "Ismini $validatsitaMessage"
                return false
            }
            if(foydalanuvchiFamil.text?.length==0)
            {
                familEditText1.error = "Familiyasini $validatsitaMessage"
                return false
            }
            if(foydalanuvchiOtasi.text?.length==0)
            {
                otasiEditText1.error = "Otasini $validatsitaMessage"
                return false
            }
            if(foydalanuvchiTugulganKuni.text?.length==0)
            {
                tugulganKunEditText1.error = "Tug'ulgan kunni $validatsitaMessage"
                return false
            }
            if(foydalanuvchiDavlat.text?.length==0)
            {
                davlatEditText1.error = "Davlatni $validatsitaMessage"
                return false
            }
            if(foydalanuvchiViloyat.text?.length==0)
            {
                viloyatEditText1.error = "Viloyatni $validatsitaMessage"
                return false
            }
            if(foydalanuvchiTel.text?.length==0)
            {
                telefonEditText1.error = "Telefonnii $validatsitaMessage"
                return false
            }
            if(foydalanuvchiEmail.text?.length==0)
            {
                emailEditText1.error = "Emailni $validatsitaMessage"
                return false
            }


        }
        return true
    }


    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
    private fun statusBar() {
        window.statusBarColor = Color.parseColor("#F3F3F3")
    }
}