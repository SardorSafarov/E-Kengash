package com.example.ekengash.servislar.turarJoylar.qidirish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.ekengash.R
import com.example.ekengash.databinding.BottomSheetTurarJoyHolatBinding
import com.example.ekengash.databinding.FragmentPoyzQidirishBinding
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
        val bottomsheetBinding =BottomSheetTurarJoyHolatBinding.bind(view)
        binding.turarJoyHolat.setOnClickListener {
            bottomsheet.show()
        }



        bottomsheetBinding.orqagaQaytish.setOnClickListener {
            bottomsheet.dismiss()
        }
        bottomsheet.setContentView(view)

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
}