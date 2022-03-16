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
    var xonalar=1
    var kattalar=0
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
        turarJoyQachongacha()
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

    private fun turarJoyQachongacha()
    {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        binding.turarJoyQachongacha.setOnClickListener {
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
            binding.qachongachaDefault.visibility = View.INVISIBLE
            binding.qachongachaTanlangan.visibility= View.VISIBLE
            binding.qachongachaText.visibility = View.VISIBLE
            binding.qachongachaText.setText(time)
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
        val turarJoyHolatBind = BottomSheetTurarJoyHolatBinding.bind(view)
        bottomsheet.setContentView(view)
        binding.turarJoyHolat.setOnClickListener {
            bottomsheet.show()
        }
        turarJoyHolatBind.davomEtishButton.setOnClickListener {

            val umumiyKishilar = kattalar+bolalar+chaqaloqlar
            if(umumiyKishilar!=0){

                binding.holatDefault.visibility = View.INVISIBLE
                binding.holatTanlanganda.visibility = View.VISIBLE
                binding.holatText.visibility = View.VISIBLE
                binding.holatText.setText(xonalar.toString()+" Xona,"+umumiyKishilar.toString()+" Kishi")
            }
            else{
                binding.holatDefault.visibility = View.VISIBLE
                binding.holatTanlanganda.visibility = View.INVISIBLE
                binding.holatText.visibility = View.INVISIBLE
            }
            bottomsheet.dismiss()
        }


        /*-----------Xonalar-----------------------*/
        turarJoyHolatBind.holatXonalarQush.setOnClickListener {
            xonalar++
            turarJoyHolatBind.holatXonalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            turarJoyHolatBind.holatXonalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            turarJoyHolatBind.xonalarSoni.text=xonalar.toString()
        }
        turarJoyHolatBind.holatXonalarKam.setOnClickListener {
            if(xonalar>1){
            xonalar--
            if(xonalar==1){
                turarJoyHolatBind.holatXonalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                turarJoyHolatBind.holatXonalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
            }
                turarJoyHolatBind.xonalarSoni.text=xonalar.toString()
            }
        }
        /*-------------Kattalar------------------*/
        turarJoyHolatBind.holatKattalarQush.setOnClickListener {
            kattalar++
            turarJoyHolatBind.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            turarJoyHolatBind.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            turarJoyHolatBind.holatKattalarSoni.text=kattalar.toString()
        }
        turarJoyHolatBind.holatKattalarKam.setOnClickListener {
            if(kattalar>0){
                kattalar--
                if(kattalar==0){
                    turarJoyHolatBind.holatKattalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    turarJoyHolatBind.holatKattalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                turarJoyHolatBind.holatKattalarSoni.text=kattalar.toString()
            }
        }
        /*----------------Bolalar------------*/
        turarJoyHolatBind.holatBolalarQush.setOnClickListener {
            bolalar++
            turarJoyHolatBind.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            turarJoyHolatBind.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_oq)
            turarJoyHolatBind.bolalarSoni.text=bolalar.toString()
        }
        turarJoyHolatBind.holatBolalarKam.setOnClickListener {
            if(bolalar>0){
                bolalar--
                if(bolalar==0){
                    turarJoyHolatBind.holatBolalarKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    turarJoyHolatBind.holatBolalarKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                turarJoyHolatBind.bolalarSoni.text=bolalar.toString()
            }
        }
        /*---------------Chaqaloqlar-------------*/
        turarJoyHolatBind.holatChaqaloqQush.setOnClickListener {
            chaqaloqlar++
            turarJoyHolatBind.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#109BFF"))
            turarJoyHolatBind.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_oq)
            turarJoyHolatBind.holatChaqaloqSoni.text=chaqaloqlar.toString()
        }
        turarJoyHolatBind.holatChaqaloqKam.setOnClickListener {
            if(chaqaloqlar>0){
                chaqaloqlar--
                if(chaqaloqlar==0){
                    turarJoyHolatBind.holatChaqaloqKamIcon.setBackgroundColor(Color.parseColor("#ffffff"))
                    turarJoyHolatBind.holatChaqaloqKamIcon.setImageResource(R.drawable.ic_minus_kuk)
                }
                turarJoyHolatBind.holatChaqaloqSoni.text=chaqaloqlar.toString()
            }
        }


        turarJoyHolatBind.orqagaQaytish.setOnClickListener {
            bottomsheet.dismiss()
        }
    }




}