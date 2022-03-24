package com.example.servislar.poyezd.qidirish

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.katrip.R
import com.example.katrip.databinding.BottomSheetAviaHolatBinding
import com.example.katrip.databinding.BottomSheetServesQayerdanBinding
import com.example.katrip.databinding.FragmentPoyzQidirishBinding
import com.example.servislar.poyezd.izlash.PoyezdIzlash
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class PoyzQidirish : Fragment() {
    private var _binding: FragmentPoyzQidirishBinding? = null
    private val binding get() = _binding!!
    var kattalar=1
    var bolalar=0
    var chaqaloqlar=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPoyzQidirishBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }



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
    private fun poyezdQachon() {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        binding.poyezdQachon.setOnClickListener {
            fragmentManager?.let { it1 -> datePicker.show(it1,"tag") }
        }
        datePicker.addOnPositiveButtonClickListener { selection: Long? ->
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            calendar.time = selection?.let { Date(it) }
            val time= avtobusQachonQachongachaText(
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_WEEK)
            )
            binding.qachonDefault.visibility = View.INVISIBLE
            binding.qachonTanlanganda.visibility= View.VISIBLE
            binding.qachonText.visibility = View.VISIBLE
            binding.qachonText.setText(time)
        }
    }

    private fun avtobusQachonQachongachaText(kun: Int, oy: Int, haftaKuni: Int):String {

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


    private fun poyezdHolat() {

        val bottomDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_avia_holat,null)
        bottomDialog.setContentView(view)
        val poyezdHolatBinding = BottomSheetAviaHolatBinding.bind(view)
        poyezdHolatBinding.beletTuri.visibility=View.GONE

        poyezdHolatBinding.davomEtishButton.setOnClickListener {
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
            bottomDialog.dismiss()
        }


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
            if(kattalar>1){
                kattalar--
                if(kattalar==1){
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
}