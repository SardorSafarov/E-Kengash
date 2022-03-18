package com.example.servislar.turarJoylar.qidirish

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
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class TurarJoyQidirish : Fragment() {
    private var _binding: FragmentTurarJoyQidirishBinding? = null
    private val binding get() = _binding!!
    var kattalar=1
    var bolalar=0
    var chaqaloqlar=0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTurarJoyQidirishBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        turarJoyHolat()
        turarJoyQachon()
    }

    private fun turarJoyQachon()
    {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        binding.turarJoyQachon.setOnClickListener {
            fragmentManager?.let { it1 -> datePicker.show(it1,"tag") }
        }
        datePicker.addOnPositiveButtonClickListener { selection: Long? ->
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            calendar.time = selection?.let { Date(it) }
            val time= turarJoyQachonQachongachaText(
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_WEEK)
            )
            binding.qachonDefault.visibility = View.INVISIBLE
            binding.qachonTanlangan.visibility= View.VISIBLE
            binding.qachonText.visibility = View.VISIBLE
            binding.qachonText.setText(time)
        }
    }



    private fun turarJoyQachonQachongachaText(kun: Int, oy: Int, haftaKuni: Int):String {

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
        return ((kun.toString() + " " + oytext + "," + haftaKuniText))
    }

    /*-------------------------Teginma--------------------------------*/
    private fun turarJoyHolat() {
        val bottomsheet=BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_turar_joy_holat,null)
        val turPaketBinding = BottomSheetTurarJoyHolatBinding.bind(view)
        bottomsheet.setContentView(view)

        binding.turarJoyHolat.setOnClickListener {
            bottomsheet.show()
        }
        turPaketBinding.davomEtishButton.setOnClickListener {

            val umumiyKishilar = kattalar+bolalar+chaqaloqlar
            if(umumiyKishilar!=0){

                binding.holatDefault.visibility = View.INVISIBLE
                binding.holatTanlanganda.visibility = View.VISIBLE
                binding.holatText.visibility = View.VISIBLE
                binding.holatText.setText(umumiyKishilar.toString()+" Kishi")
            }
            else{
                binding.holatDefault.visibility = View.VISIBLE
                binding.holatTanlanganda.visibility = View.INVISIBLE
                binding.holatText.visibility = View.INVISIBLE
            }
            bottomsheet.dismiss()
        }
        /*-------------Kattalar------------------*/
        turPaketBinding.holatKattalarQush.setOnClickListener {
            kattalar++
            turPaketBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            turPaketBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            turPaketBinding.holatKattalarSoni.text=kattalar.toString()
        }
        turPaketBinding.holatKattalarKam.setOnClickListener {
            if(kattalar>1){
                kattalar--
                if(kattalar==1){
                    turPaketBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    turPaketBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                turPaketBinding.holatKattalarSoni.text=kattalar.toString()
            }
        }
        /*----------------Bolalar------------*/
        turPaketBinding.holatBolalarQush.setOnClickListener {
            bolalar++
            turPaketBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            turPaketBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            turPaketBinding.bolalarSoni.text=bolalar.toString()
        }
        turPaketBinding.holatBolalarKam.setOnClickListener {
            if(bolalar>0){
                bolalar--
                if(bolalar==0){
                    turPaketBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    turPaketBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                turPaketBinding.bolalarSoni.text=bolalar.toString()
            }
        }
        /*---------------Chaqaloqlar-------------*/
        turPaketBinding.holatChaqaloqQush.setOnClickListener {
            chaqaloqlar++
            turPaketBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            turPaketBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_oq)
            turPaketBinding.holatChaqaloqSoni.text=chaqaloqlar.toString()
        }
        turPaketBinding.holatChaqaloqKam.setOnClickListener {
            if(chaqaloqlar>0){
                chaqaloqlar--
                if(chaqaloqlar==0){
                    turPaketBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    turPaketBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                turPaketBinding.holatChaqaloqSoni.text=chaqaloqlar.toString()
            }
        }


        turPaketBinding.orqagaQaytish.setOnClickListener {
            bottomsheet.dismiss()
        }
    }




}