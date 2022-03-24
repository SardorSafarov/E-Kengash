package com.example.chapMenu.profil.biznes.biznesProfilQushish

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.chapMenu.profil.biznes.sms.BiznesProfilQurishSms
import com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.passprtMalumotlari.PassportMalumotlar
import com.example.constants.Constants
import com.example.ekengash.databinding.ActivityProfilBiznesProfilQushishBinding
import com.example.log.D
import com.example.network.endtity.profil.biznes.surov.BiznesSurov
import com.example.network.endtity.profil.shaxsniTasdiqlash.shaxsiy.ShaxsiyMalumotlarSurov
import com.example.network.repository.profil.ProfilRepository
import com.example.network.viewModelFactory.kirish.ProfilViewModelFactory
import com.example.network.viewmodel.profil.ProfilViewModel

class ProfilBiznesProfilQushish : AppCompatActivity() {
    private lateinit var binding: ActivityProfilBiznesProfilQushishBinding
    private lateinit var profilViewModel: ProfilViewModel
    private val validatsitaMessage = "to'ldirilishi shart"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBiznesProfilQushishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBar()
        ortgaQaytish()
        setUi()
        davomEtish()

    }


    private fun setUi() {
        val profilRepository = ProfilRepository()
        val profilViewModelFactory =
            ProfilViewModelFactory(profilRepository)
        val profilViewModel = ViewModelProvider(
            this,
            profilViewModelFactory
        ).get(ProfilViewModel::class.java)
        this.profilViewModel = profilViewModel
    }

    private fun davomEtish() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Xatolik!!")
        alertDialog.setMessage("Iltimos, sahifadagi barcha maydonlarni to'ldiring!")
        alertDialog.setPositiveButton("Tushundim") { dialogInterface: DialogInterface, i: Int -> }
        binding.davomEtishButton.setOnClickListener {
            if (validatsiyaEditText()) {
                biznesMalumotQushish()
                startActivity(Intent(this, BiznesProfilQurishSms::class.java))
                finish()
            } else {
                alertDialog.show()
            }

        }
    }

    private fun biznesMalumotQushish() {
        binding.apply {
            profilViewModel.biznesMalumotlarQushish(Constants.TOKEN, BiznesSurov(
                org_bank_accauntnumber = hisobRaqamText.text.toString(),
                org_bank_mfo = mfoText.text.toString(),
                org_bank_name =bankNomiText.text.toString(),
                org_country = davlatText.text.toString(),
                org_director_name = direktorText.text.toString(),
                org_email = tashEmilText.text.toString(),
                org_name = tashlilotNomiText.text.toString(),
                org_official_adress =yuridikManzilText.text.toString(),
                org_official_name = tashRasmiyNomiText.text.toString(),
                org_phone = tashTelText.text.toString(),
                org_phone2 = tashTel2Text.text.toString(),
                org_postindex = pochtaIndeksText.text.toString(),
                org_stir = tashStirText.text.toString(),
                org_type = tashkilotTuriText.text.toString()
            )
            )
            {
                if (it.isSuccessful) {
                    D.d(it.body()!!.status)
                    if (it.body()!!.status == "success")
                        Toast.makeText(applicationContext,
                            "Ma'lumolar qo'shildi",
                            Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun validatsiyaEditText(): Boolean {
        binding.apply {
            if (tashkilotTuriText.text?.length == 0) {
                tashkilotTuri.error = "Tashkilot turini $validatsitaMessage"
                return false
            }
            if (tashlilotNomiText.text?.length == 0) {
                tashlilotNomi.error = "Korxona $validatsitaMessage"
                return false
            }
            if (tashRasmiyNomiText.text?.length == 0) {
                tashRasmiyNomi.error = "Rasmit nomi $validatsitaMessage"
                return false
            }
            if (direktorText.text?.length == 0) {
                direktor.error = "Direktor $validatsitaMessage"
                return false
            }
            if (tashTelText.text?.length == 0) {
                tashTel.error = "Tel $validatsitaMessage"
                return false
            }
            if (tashTel2Text.text?.length == 0) {
                tashTel2.error = "Qo'shimcha tel $validatsitaMessage"
                return false
            }
            if (tashEmilText.text?.length == 0) {
                tashEmil.error = "Email $validatsitaMessage"
                return false
            }
            if (tashStirText.text?.length == 0) {
                tashStir.error = "STIR $validatsitaMessage"
                return false
            }
            if (bankNomiText.text?.length == 0) {
                bankNomi.error = "Bank $validatsitaMessage"
                return false
            }
            if (mfoText.text?.length == 0) {
                mfo.error = "MFO $validatsitaMessage"
                return false
            }
            if (hisobRaqamText.text?.length == 0) {
                hisobRaqam.error = "Hisob Raqam $validatsitaMessage"
                return false
            }
            if (davlatText.text?.length == 0) {
                davlat.error = "Davlat $validatsitaMessage"
                return false
            }
            if (yuridikManzilText.text?.length == 0) {
                yuridikManzil.error = "Yuridik Manzil $validatsitaMessage"
                return false
            }
            if (pochtaIndeksText.text?.length == 0) {
                pochtaIndeks.error = "Pochta Indeks $validatsitaMessage"
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
        window.statusBarColor = Color.WHITE
    }

}