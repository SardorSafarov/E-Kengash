package com.example.servislar.ab.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityServesAbBinding
import com.example.ekengash.databinding.BottomSheetAviaHolatBinding
import com.example.ekengash.databinding.BottomSheetServesQayerdanBinding
import com.example.servislar.ab.izlash.ABIzlash
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.datepicker.MaterialDatePicker

class ServesAB : AppCompatActivity() {
    private lateinit var binding:ActivityServesAbBinding
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
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        binding.abQachon.setOnClickListener {
            supportFragmentManager?.let { it1 -> datePicker.show(it1,"tag") }
        }
    }

    private fun abQayerdan() {
        val bottomsheet= BottomSheetDialog(this, R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_serves_qayerdan,null)
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
        val bottomsheet= BottomSheetDialog(this, R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_serves_qayerdan,null)
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
            startActivity(Intent(this,ABIzlash::class.java))
        }
    }

    private fun poyezdHolat() {

        val bottomDialog = BottomSheetDialog(this, R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_avia_holat,null)
        bottomDialog.setContentView(view)
        val poyezdHolatBinding = BottomSheetAviaHolatBinding.bind(view)
        poyezdHolatBinding.beletTuri.visibility= View.GONE
        poyezdHolatBinding.orqagaQaytish.setOnClickListener {
            bottomDialog.dismiss()
        }
/*-------------Kattalar------------------*/
        poyezdHolatBinding.holatKattalarQush.setOnClickListener {
            kattalar++
            poyezdHolatBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            poyezdHolatBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            poyezdHolatBinding.holatKattalarSoni.text=kattalar.toString()
        }
        poyezdHolatBinding.holatKattalarKam.setOnClickListener {
            if(kattalar>0){
                kattalar--
                if(kattalar==0){
                    poyezdHolatBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    poyezdHolatBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                poyezdHolatBinding.holatKattalarSoni.text=kattalar.toString()
            }
        }
        /*----------------Bolalar------------*/
        poyezdHolatBinding.holatBolalarQush.setOnClickListener {
            bolalar++
            poyezdHolatBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            poyezdHolatBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            poyezdHolatBinding.bolalarSoni.text=bolalar.toString()
        }
        poyezdHolatBinding.holatBolalarKam.setOnClickListener {
            if(bolalar>0){
                bolalar--
                if(bolalar==0){
                    poyezdHolatBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    poyezdHolatBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                poyezdHolatBinding.bolalarSoni.text=bolalar.toString()
            }
        }
        /*---------------Chaqaloqlar-------------*/
        poyezdHolatBinding.holatChaqaloqQush.setOnClickListener {
            chaqaloqlar++
            poyezdHolatBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            poyezdHolatBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_oq)
            poyezdHolatBinding.holatChaqaloqSoni.text=chaqaloqlar.toString()
        }
        poyezdHolatBinding.holatChaqaloqKam.setOnClickListener {
            if(chaqaloqlar>0){
                chaqaloqlar--
                if(chaqaloqlar==0){
                    poyezdHolatBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    poyezdHolatBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                poyezdHolatBinding.holatChaqaloqSoni.text=chaqaloqlar.toString()
            }
        }
        binding.abHolat.setOnClickListener {
            bottomDialog.show()
        }
    }
    private fun statusBar() {
        window.statusBarColor = Color.parseColor("#F3F3F3")
    }
    var kattalar=0
    var bolalar=0
    var chaqaloqlar=0
}