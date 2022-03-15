package com.example.servislar.ab.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityServesAbBinding
import com.example.ekengash.databinding.BottomSheetAviaHolatBinding
import com.example.ekengash.databinding.BottomSheetServesQayerdanBinding
import com.example.log.D
import com.example.servislar.ab.izlash.ABIzlash
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class ServesAB : AppCompatActivity() {
    private lateinit var binding: ActivityServesAbBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServesAbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        poyezdHolat()
        izlash()
        statusBar()
        orqagaQaytish()
        abQayerdan()
        abQayerga()
        abQachon()
    }

    private fun abQachon() {

        val calendar = Calendar.getInstance()
        val kun = calendar[Calendar.DAY_OF_MONTH]
        val haftaKuni = calendar[Calendar.DAY_OF_WEEK]
        val oy = calendar[Calendar.MONTH]
        abQachonText(kun = kun, oy = oy, haftaKuni = haftaKuni)
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        binding.abQachon.setOnClickListener {
            supportFragmentManager?.let { it1 -> datePicker.show(it1, "tag") }
        }
        datePicker.addOnPositiveButtonClickListener { selection: Long? ->
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            calendar.time = selection?.let { Date(it) }
            abQachonText(
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_WEEK)
            )
        }

    }

    private fun abQachonText(kun: Int, oy: Int, haftaKuni: Int) {

        val oytext = when (oy + 1) {
            1 -> "Yan"
            2 -> "Fev"
            3 -> "Mar"
            4 -> "Apr"
            5 -> "May"
            6 -> "June"
            7 -> "July"
            8 -> "Aug"
            9 -> "Sep"
            10 -> "Oct"
            11 -> "Noya"
            12 -> "Dek"

            else -> {}
        }
        val haftaKuniText = when (haftaKuni) {
            1 -> "Yak"
            2 -> "Dush"
            3 -> "Sesh"
            4 -> "Chor"
            5 -> "Pay"
            6 -> "Juma"
            7 -> "Shan"
            else -> {}
        }
        binding.abQachonText.setText((kun.toString() + " " + oytext + "," + haftaKuniText))
    }

    private fun abQayerdan() {
        val bottomsheet = BottomSheetDialog(this, R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_serves_qayerdan, null)
        val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
        bottomsheet.setContentView(view)
        bottomsheetBinding.chiqish.setOnClickListener {
            bottomsheet.dismiss()
        }
        binding.abQayerdan.setOnClickListener {
            bottomsheet.show()
        }
    }

    private fun abQayerga() {
        val bottomsheet = BottomSheetDialog(this, R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_serves_qayerdan, null)
        val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
        bottomsheet.setContentView(view)
        bottomsheetBinding.chiqish.setOnClickListener {
            bottomsheet.dismiss()
        }
        bottomsheetBinding.textView11.setText("Qayerga")
        binding.abQayerga.setOnClickListener {
            bottomsheet.show()
        }
    }

    private fun orqagaQaytish() {
        binding.orqagaQaytishAb.setOnClickListener {
            finish()
        }
    }


    private fun izlash() {
        binding.abIzlash.setOnClickListener {
            startActivity(Intent(this, ABIzlash::class.java))
        }
    }

    private fun poyezdHolat() {

        val bottomDialog = BottomSheetDialog(this, R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_avia_holat, null)
        bottomDialog.setContentView(view)
        val poyezdHolatBinding = BottomSheetAviaHolatBinding.bind(view)
        poyezdHolatBinding.beletTuri.visibility = View.GONE
        poyezdHolatBinding.orqagaQaytish.setOnClickListener {
            bottomDialog.dismiss()
        }
/*-------------Kattalar------------------*/
        poyezdHolatBinding.holatKattalarQush.setOnClickListener {
            kattalar++
            poyezdHolatBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            poyezdHolatBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            poyezdHolatBinding.holatKattalarSoni.text = kattalar.toString()
        }
        poyezdHolatBinding.holatKattalarKam.setOnClickListener {
            if (kattalar > 0) {
                kattalar--
                if (kattalar == 0) {
                    poyezdHolatBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    poyezdHolatBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                poyezdHolatBinding.holatKattalarSoni.text = kattalar.toString()
            }
        }
        /*----------------Bolalar------------*/
        poyezdHolatBinding.holatBolalarQush.setOnClickListener {
            bolalar++
            poyezdHolatBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            poyezdHolatBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            poyezdHolatBinding.bolalarSoni.text = bolalar.toString()
        }
        poyezdHolatBinding.holatBolalarKam.setOnClickListener {
            if (bolalar > 0) {
                bolalar--
                if (bolalar == 0) {
                    poyezdHolatBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    poyezdHolatBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                poyezdHolatBinding.bolalarSoni.text = bolalar.toString()
            }
        }
        /*---------------Chaqaloqlar-------------*/
        poyezdHolatBinding.holatChaqaloqQush.setOnClickListener {
            chaqaloqlar++
            poyezdHolatBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            poyezdHolatBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_oq)
            poyezdHolatBinding.holatChaqaloqSoni.text = chaqaloqlar.toString()
        }
        poyezdHolatBinding.holatChaqaloqKam.setOnClickListener {
            if (chaqaloqlar > 0) {
                chaqaloqlar--
                if (chaqaloqlar == 0) {
                    poyezdHolatBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    poyezdHolatBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                poyezdHolatBinding.holatChaqaloqSoni.text = chaqaloqlar.toString()
            }
        }
        binding.abHolat.setOnClickListener {
            bottomDialog.show()
        }
    }

    private fun statusBar() {
        window.statusBarColor = Color.parseColor("#F3F3F3")
    }

    var kattalar = 0
    var bolalar = 0
    var chaqaloqlar = 0
}