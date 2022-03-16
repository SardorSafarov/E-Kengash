package com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.passprtMalumotlari

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.sms.ShaxsiyProfilTasdiqlashSms
import com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.yuzniScanerlash.YuzniSkanerlash
import com.example.ekengash.databinding.ActivityPassportMalumotlarBinding

class PassportMalumotlar : AppCompatActivity() {
    private lateinit var binding:ActivityPassportMalumotlarBinding
    private val validatsitaMessage="to'ldirilishi shart"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPassportMalumotlarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbar()
        orqagaQaytish()
        davomEtish()
    }



    private fun davomEtish() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Xatolik!!")
        alertDialog.setMessage("Iltimos, sahifadagi barcha maydonlarni to'ldiring!")
        alertDialog.setPositiveButton("Tushundim"){ dialogInterface: DialogInterface, i: Int -> }
        binding.davomEtishButton.setOnClickListener {
            if(validatsiyaEditText()){
                startActivity(Intent(this,ShaxsiyProfilTasdiqlashSms::class.java))
            }else
            {
                alertDialog.show()
            }

        }
    }

    private fun validatsiyaEditText(): Boolean {
        binding.apply {
            if(passportSeriya.text?.length==0)
            {
                passportSeriyaEdit.error = "Seriyasini $validatsitaMessage"
                return false
            }
            if(passportJshsher.text?.length==0)
            {
                passportJshsherEdit.error = "JSHSHIRni $validatsitaMessage"
                return false
            }
            if(passportKimBerdi.text?.length==0)
            {
                passportKimBerdiEdit.error = "Kim tomonidan berilganni $validatsitaMessage"
                return false
            }
            if(passportBerilgan.text?.length==0)
            {
                passportBerilganEdit.error = "Berilgan vaqtini $validatsitaMessage"
                return false
            }
            if(passportAmalqilishUddati.text?.length==0)
            {
                passportAmalqilishUddatiEdit.error = "Amal qilish muddatini $validatsitaMessage"
                return false
            }
            if(tugulganDavlati.text?.length==0)
            {
                tugulganDavlatiEdit.error = "Tug'ulgan davlatni $validatsitaMessage"
                return false
            }
            if(doimyYashash.text?.length==0)
            {
                doimiyYashashEdit.error = "Doimiy yashashni $validatsitaMessage"
                return false
            }


        }
        return true
    }
    private fun statusbar() {
        window.statusBarColor = Color.parseColor("#F3F3F3")
    }

    private fun orqagaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }
}