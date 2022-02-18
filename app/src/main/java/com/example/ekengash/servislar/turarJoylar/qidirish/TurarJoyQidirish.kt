package com.example.ekengash.servislar.turarJoylar.qidirish

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ekengash.R
import com.example.ekengash.databinding.BottomSheetTurarJoyHolatBinding
import com.example.ekengash.databinding.FragmentTurarJoyQidirishBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class TurarJoyQidirish : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bottomSheetDialog()

    }



    /*-------------------------Teginma--------------------------------*/
    private fun bottomSheetDialog() {
        val bottomsheet=BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_turar_joy_holat,null)
        val bottomsheetBinding = BottomSheetTurarJoyHolatBinding.bind(view)
        bottomsheet.setContentView(view)
        binding.turarJoyHolat.setOnClickListener {
            bottomsheet.show()
        }
        /*-----------Xonalar-----------------------*/
        bottomsheetBinding.holatXonalarQush.setOnClickListener {
            xonalar++
            bottomsheetBinding.holatXonalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            bottomsheetBinding.holatXonalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            bottomsheetBinding.xonalarSoni.text=xonalar.toString()
        }
        bottomsheetBinding.holatXonalarKam.setOnClickListener {
            if(xonalar>0){
            xonalar--
            if(xonalar==0){
                bottomsheetBinding.holatXonalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                bottomsheetBinding.holatXonalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
            }
            bottomsheetBinding.xonalarSoni.text=xonalar.toString()
            }
        }
        /*-------------Kattalar------------------*/
        bottomsheetBinding.holatKattalarQush.setOnClickListener {
            kattalar++
            bottomsheetBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            bottomsheetBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            bottomsheetBinding.holatKattalarSoni.text=kattalar.toString()
        }
        bottomsheetBinding.holatKattalarKam.setOnClickListener {
            if(kattalar>0){
                kattalar--
                if(kattalar==0){
                    bottomsheetBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    bottomsheetBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                bottomsheetBinding.holatKattalarSoni.text=kattalar.toString()
            }
        }
        /*----------------Bolalar------------*/
        bottomsheetBinding.holatBolalarQush.setOnClickListener {
            bolalar++
            bottomsheetBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            bottomsheetBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            bottomsheetBinding.bolalarSoni.text=bolalar.toString()
        }
        bottomsheetBinding.holatBolalarKam.setOnClickListener {
            if(bolalar>0){
                bolalar--
                if(bolalar==0){
                    bottomsheetBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    bottomsheetBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                bottomsheetBinding.bolalarSoni.text=bolalar.toString()
            }
        }
        /*---------------Chaqaloqlar-------------*/
        bottomsheetBinding.holatChaqaloqQush.setOnClickListener {
            chaqaloqlar++
            bottomsheetBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            bottomsheetBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_oq)
            bottomsheetBinding.holatChaqaloqSoni.text=chaqaloqlar.toString()
        }
        bottomsheetBinding.holatChaqaloqKam.setOnClickListener {
            if(chaqaloqlar>0){
                chaqaloqlar--
                if(chaqaloqlar==0){
                    bottomsheetBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    bottomsheetBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                bottomsheetBinding.holatChaqaloqSoni.text=chaqaloqlar.toString()
            }
        }


        bottomsheetBinding.orqagaQaytish.setOnClickListener {
            bottomsheet.dismiss()
        }
    }



    private var _binding: FragmentTurarJoyQidirishBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTurarJoyQidirishBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    var xonalar=0
    var kattalar=0
    var bolalar=0
    var chaqaloqlar=0
}