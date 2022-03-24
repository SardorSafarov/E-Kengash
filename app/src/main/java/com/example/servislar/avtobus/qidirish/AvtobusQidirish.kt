package com.example.servislar.avtobus.qidirish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.katrip.R
import com.example.katrip.databinding.BottomSheetServesQayerdanBinding
import com.example.katrip.databinding.FragmentAvtobusQidirishBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class AvtobusQidirish : Fragment() {
    private var _binding: FragmentAvtobusQidirishBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAvtobusQidirishBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        avtobusQayerdan()
        avtobusQayerga()
        avtobusQachon()
    }

//    private fun avtobusQachon() {
//        val bottomDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetDiaolg)
//        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_calendar,null)
//        bottomDialog.setContentView(view)
//        val qachonBinding = BottomSheetCalendarBinding.bind(view)
//        binding.avtobusQachon.setOnClickListener {
//            bottomDialog.show()
//        }
//        qachonBinding.chiqish.setOnClickListener {
//            bottomDialog.dismiss()
//        }
//    }
        /*----------------Tegma----------------------*/
private fun avtobusQachon() {
    val datePicker =
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
    binding.avtobusQachon.setOnClickListener {
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

    private fun avtobusQayerga() {
        val bottomsheet= BottomSheetDialog(requireContext(), R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_serves_qayerdan,null)
        val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
        bottomsheet.setContentView(view)
        bottomsheetBinding.chiqish.setOnClickListener {
            bottomsheet.dismiss()
        }
        bottomsheetBinding.textView11.setText("Qayerga")
        binding.avtobusQayerga.setOnClickListener {
            bottomsheet.show()
        }
    }
    private fun avtobusQayerdan() {
        val bottomsheet= BottomSheetDialog(requireContext(), R.style.BottomSheetDiaolg)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_serves_qayerdan,null)
        val bottomsheetBinding = BottomSheetServesQayerdanBinding.bind(view)
        bottomsheet.setContentView(view)
        bottomsheetBinding.chiqish.setOnClickListener {
            bottomsheet.dismiss()
        }
        binding.avtobusQayerdan.setOnClickListener {
            bottomsheet.show()
        }
    }








}