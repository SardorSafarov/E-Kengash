package com.example.servislar.aviachipta.qidirish

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ekengash.R
import com.example.ekengash.databinding.BottomSheetAviaHolatBinding
import com.example.ekengash.databinding.BottomSheetCalendarBinding
import com.example.ekengash.databinding.BottomSheetServesQayerdanBinding
import com.example.ekengash.databinding.FragmentAviaQidirishBinding
import com.example.log.D
import com.example.servislar.aviachipta.izlash.AviaIzlash
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*


class AviaQidirish : Fragment() {




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        teginma()
    }




    /*------------------------Teginma---------------Tegma----------------------*/


    private fun teginma() {
        aviQachon()
        aviQachongacha()
        aviaQayedan()
        aviaQayerga()
        aviaHolat()
        aviaIzlash()
    }

    private fun aviaHolat() {
        val bottomDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_avia_holat,null)
        bottomDialog.setContentView(view)
        val holatBinding = BottomSheetAviaHolatBinding.bind(view)
     /*-------------Kattalar------------------*/
        holatBinding.holatKattalarQush.setOnClickListener {
            kattalar++
            holatBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            holatBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            holatBinding.holatKattalarSoni.text=kattalar.toString()
        }
        holatBinding.holatKattalarKam.setOnClickListener {
            if(kattalar>0){
                kattalar--
                if(kattalar==0){
                    holatBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    holatBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                holatBinding.holatKattalarSoni.text=kattalar.toString()
            }
        }
        /*----------------Bolalar------------*/
        holatBinding.holatBolalarQush.setOnClickListener {
            bolalar++
            holatBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            holatBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            holatBinding.bolalarSoni.text=bolalar.toString()
        }
        holatBinding.holatBolalarKam.setOnClickListener {
            if(bolalar>0){
                bolalar--
                if(bolalar==0){
                    holatBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    holatBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                holatBinding.bolalarSoni.text=bolalar.toString()
            }
        }
        /*---------------Chaqaloqlar-------------*/
        holatBinding.holatChaqaloqQush.setOnClickListener {
            chaqaloqlar++
            holatBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            holatBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_oq)
            holatBinding.holatChaqaloqSoni.text=chaqaloqlar.toString()
        }
        holatBinding.holatChaqaloqKam.setOnClickListener {
            if(chaqaloqlar>0){
                chaqaloqlar--
                if(chaqaloqlar==0){
                    holatBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    holatBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                holatBinding.holatChaqaloqSoni.text=chaqaloqlar.toString()
            }
        }
        /*----------Bottom Sheetni chiqrish----------------------*/
        binding.aviaHolat.setOnClickListener {
        bottomDialog.show()
        }
        holatBinding.orqagaQaytish.setOnClickListener {
            bottomDialog.dismiss()
        }
    }

    private fun aviaIzlash() {
        binding.aviaIzlash.setOnClickListener {
            startActivity(Intent(context,AviaIzlash::class.java))
        }

    }

    private fun aviQachongacha() {
        val calendar = Calendar.getInstance()
        val bottomDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_calendar,null)
        bottomDialog.setContentView(view)
        val qachonBinding = BottomSheetCalendarBinding.bind(view)
        qachonBinding.textView22.text="Qachongacha"
        var oyPosition = 0
        var yilPosition = 0
        qachonBinding.oylar.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.Oylar))

//        qachonBinding.oylar.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View,
//                position: Int,
//                id: Long
//            ) {
//                 oyPosition = position
//                (view as TextView).setTextColor(Color.parseColor("#109BFF")) //Change selected text color
//                calendar.set(
//                    yilPosition, // year
//                    oyPosition,
//                    1
//                )
//
//            }
//            override fun onNothingSelected(parent: AdapterView<*>?) {}
//        })
//
//        qachonBinding.yillar.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View,
//                position: Int,
//                id: Long
//            ) {
//                (view as TextView).setTextColor(Color.parseColor("#109BFF"))
//                yilPosition=resources.getStringArray(R.array.Yillar)[position].toInt()
//                calendar.set(
//                    yilPosition, // year
//                    oyPosition,
//                    1
//                )
//                qachonBinding.calendarView.setDate(
//                    calendar.timeInMillis,
//                    false,
//                    false
//                )
//                D.d("$oyPosition    $yilPosition")
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {}
//        })

            calendar.set(
                    2022, // year
                    1,
                    1
                )
        qachonBinding.calendarView.setDate(
            calendar.timeInMillis,
            false,
            false
        )



        qachonBinding.yillar.adapter=ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.Yillar))

        binding.aviaQachongacha.setOnClickListener {
            bottomDialog.show()
        }
        qachonBinding.chiqish.setOnClickListener {
            bottomDialog.dismiss()
        }
    }

    private fun aviaQayerga() {
        val bottomsheet=BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_serves_qayerdan,null)
        val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
        bottomsheet.setContentView(view)
        bottomsheetBinding.textView11.text="Qayerga"
        bottomsheetBinding.chiqish.setOnClickListener {
            bottomsheet.dismiss()
        }
        binding.aviaQayerga.setOnClickListener {
            bottomsheet.show()
        }

    }

    private fun aviaQayedan() {
        val bottomsheet=BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_serves_qayerdan,null)
        val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
        bottomsheet.setContentView(view)
        bottomsheetBinding.chiqish.setOnClickListener {
            bottomsheet.dismiss()
        }
        binding.aviaQayerdan.setOnClickListener {
            bottomsheet.show()
        }
    }

    private fun aviQachon() {
        val bottomDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_calendar,null)
        bottomDialog.setContentView(view)
        val qachonBinding = BottomSheetCalendarBinding.bind(view)
        binding.aviaQachon.setOnClickListener {
            bottomDialog.show()
        }
        qachonBinding.chiqish.setOnClickListener {
            bottomDialog.dismiss()
        }
    }

    private var _binding: FragmentAviaQidirishBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAviaQidirishBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    var kattalar=0
    var bolalar=0
    var chaqaloqlar=0

}