package com.example.servislar.poyezd.qidirish

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ekengash.R
import com.example.ekengash.databinding.BottomSheetAviaHolatBinding
import com.example.ekengash.databinding.BottomSheetCalendarBinding
import com.example.ekengash.databinding.BottomSheetServesQayerdanBinding
import com.example.ekengash.databinding.FragmentPoyzQidirishBinding
import com.example.servislar.poyezd.izlash.PoyezdIzlash
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class PoyzQidirish : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.poyezdIzlash.setOnClickListener {
            startActivity(Intent(context,PoyezdIzlash::class.java))
        }
        poyezdQayerdan()
        poyezdQayerga()
        poyezdQachon()
        poyezdHolat()
    }

    private fun poyezdHolat() {

        val bottomDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_avia_holat,null)
        bottomDialog.setContentView(view)
        val poyezdHolatBinding = BottomSheetAviaHolatBinding.bind(view)
        poyezdHolatBinding.beletTuri.visibility=View.GONE
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
        binding.poyezdHolati.setOnClickListener {
            bottomDialog.show()
        }
    }

//    private fun poyezdQachon() {
//        val bottomDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
//        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_calendar,null)
//        bottomDialog.setContentView(view)
//        val qachonBinding = BottomSheetCalendarBinding.bind(view)
//        binding.poyezdQachon.setOnClickListener {
//            bottomDialog.show()
//        }
//        qachonBinding.chiqish.setOnClickListener {
//            bottomDialog.dismiss()
//        }
//    }
private fun poyezdQachon() {
    val datePicker =
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
    binding.poyezdQachon.setOnClickListener {
        fragmentManager?.let { it1 -> datePicker.show(it1,"tag") }
    }
}


    private fun poyezdQayerdan() {
        val bottomsheet= BottomSheetDialog(requireContext(), R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_serves_qayerdan,null)
        val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
        bottomsheet.setContentView(view)
        bottomsheetBinding.chiqish.setOnClickListener {
            bottomsheet.dismiss()
        }
        binding.poyezdQayerdan.setOnClickListener {
            bottomsheet.show()
        }
    }
    private fun poyezdQayerga() {
        val bottomsheet= BottomSheetDialog(requireContext(), R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_serves_qayerdan,null)
        val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
        bottomsheet.setContentView(view)
        bottomsheetBinding.chiqish.setOnClickListener {
            bottomsheet.dismiss()
        }
        bottomsheetBinding.textView11.setText("Qayerga")
        binding.poyezdQayerga.setOnClickListener {
            bottomsheet.show()
        }
    }

    /*----------------Tegma----------------------*/
    private var _binding: FragmentPoyzQidirishBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPoyzQidirishBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    var kattalar=0
    var bolalar=0
    var chaqaloqlar=0
}