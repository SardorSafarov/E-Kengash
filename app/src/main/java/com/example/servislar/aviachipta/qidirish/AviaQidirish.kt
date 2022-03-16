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
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class AviaQidirish : Fragment() {
    private var _binding: FragmentAviaQidirishBinding? = null
    private val binding get() = _binding!!
    var kattalar=0
    var bolalar=0
    var chaqaloqlar=0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAviaQidirishBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }




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
        val aviaholatBinding = BottomSheetAviaHolatBinding.bind(view)
        aviaholatBinding.davomEtishButton.setOnClickListener {
            val umumiyKishilar = kattalar+bolalar+chaqaloqlar
            if(umumiyKishilar!=0){
                if(aviaholatBinding.aviaEkonom.isChecked)
                {
                    binding.holatKlass.setText("Ekonom")
                }
                else
                {
                    binding.holatKlass.setText("Business")
                }
                binding.holatDefault.visibility = View.INVISIBLE
                binding.holatTanlanganda.visibility = View.VISIBLE
                binding.holatText.visibility = View.VISIBLE
                binding.holatKlass.visibility = View.VISIBLE
                binding.holatText.setText(umumiyKishilar.toString()+" Kishi, ")
            }
            else{
                binding.holatDefault.visibility = View.VISIBLE
                binding.holatTanlanganda.visibility = View.INVISIBLE
                binding.holatText.visibility = View.INVISIBLE
                binding.holatKlass.visibility = View.INVISIBLE
            }
            bottomDialog.dismiss()
        }
     /*-------------Kattalar------------------*/
        aviaholatBinding.holatKattalarQush.setOnClickListener {
            kattalar++
            aviaholatBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            aviaholatBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            aviaholatBinding.holatKattalarSoni.text=kattalar.toString()
        }
        aviaholatBinding.holatKattalarKam.setOnClickListener {
            if(kattalar>0){
                kattalar--
                if(kattalar==0){
                    aviaholatBinding.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    aviaholatBinding.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                aviaholatBinding.holatKattalarSoni.text=kattalar.toString()
            }
        }
        /*----------------Bolalar------------*/
        aviaholatBinding.holatBolalarQush.setOnClickListener {
            bolalar++
            aviaholatBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            aviaholatBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            aviaholatBinding.bolalarSoni.text=bolalar.toString()
        }
        aviaholatBinding.holatBolalarKam.setOnClickListener {
            if(bolalar>0){
                bolalar--
                if(bolalar==0){
                    aviaholatBinding.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    aviaholatBinding.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                aviaholatBinding.bolalarSoni.text=bolalar.toString()
            }
        }
        /*---------------Chaqaloqlar-------------*/
        aviaholatBinding.holatChaqaloqQush.setOnClickListener {
            chaqaloqlar++
            aviaholatBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            aviaholatBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_oq)
            aviaholatBinding.holatChaqaloqSoni.text=chaqaloqlar.toString()
        }
        aviaholatBinding.holatChaqaloqKam.setOnClickListener {
            if(chaqaloqlar>0){
                chaqaloqlar--
                if(chaqaloqlar==0){
                    aviaholatBinding.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    aviaholatBinding.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                aviaholatBinding.holatChaqaloqSoni.text=chaqaloqlar.toString()
            }
        }
        /*----------Bottom Sheetni chiqrish----------------------*/
        binding.aviaHolat.setOnClickListener {
        bottomDialog.show()
        }
        aviaholatBinding.orqagaQaytish.setOnClickListener {
            bottomDialog.dismiss()
        }
    }

    private fun aviaIzlash() {
        binding.aviaIzlash.setOnClickListener {
            startActivity(Intent(context,AviaIzlash::class.java))
        }

    }
    ///oldingi kalandar///
    //    private fun aviQachongacha() {
//        val calendar = Calendar.getInstance()
//        val bottomDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
//        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_calendar,null)
//        bottomDialog.setContentView(view)
//        val qachonBinding = BottomSheetCalendarBinding.bind(view)
//        qachonBinding.textView22.text="Qachongacha"
//        binding.aviaQachongacha.setOnClickListener {
//            bottomDialog.show()
//        }
//        qachonBinding.chiqish.setOnClickListener {
//            bottomDialog.dismiss()
//        }
//    }

//    private fun aviQachon() {
//        val bottomDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
//        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_calendar,null)
//        bottomDialog.setContentView(view)
//        val qachonBinding = BottomSheetCalendarBinding.bind(view)
//        binding.aviaQachon.setOnClickListener {
//            bottomDialog.show()
//        }
//        qachonBinding.chiqish.setOnClickListener {
//            bottomDialog.dismiss()
//        }
//    }
    /////////////////////




private fun aviQachongacha() {
    val datePicker =
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
    binding.aviaQachongacha.setOnClickListener {
        fragmentManager?.let { it1 -> datePicker.show(it1,"tag") }
    }
    datePicker.addOnPositiveButtonClickListener { selection: Long? ->
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        calendar.time = selection?.let { Date(it) }
        val time= aviaQachonQachongachaText(
            calendar.get(Calendar.DAY_OF_MONTH),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_WEEK)
        )
        binding.qachongachaDefault.visibility = View.INVISIBLE
        binding.qachongachaTanlangan.visibility= View.VISIBLE
        binding.qachongachaText.visibility = View.VISIBLE
        binding.qachongachaText.setText(time)
    }
}

private fun aviQachon() {
    val datePicker =
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
    binding.aviaQachon.setOnClickListener {
        fragmentManager?.let { it1 -> datePicker.show(it1,"tag") }
    }
    datePicker.addOnPositiveButtonClickListener { selection: Long? ->
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        calendar.time = selection?.let { Date(it) }
        val time= aviaQachonQachongachaText(
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

    private fun aviaQachonQachongachaText(kun: Int, oy: Int, haftaKuni: Int):String {

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




}