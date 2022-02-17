package com.example.ekengash.servislar.aviachipta.qidirish

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentAviaQidirishBinding
import com.example.ekengash.databinding.FragmentKuproqBinding
import com.example.ekengash.servislar.aviachipta.bootomsheet.QayerdanAvia
import com.example.ekengash.servislar.aviachipta.bootomsheet.QayergaAvia
import com.example.ekengash.servislar.aviachipta.izlash.AviaIzlash
import com.example.log.D
import com.google.android.material.bottomsheet.BottomSheetDialog


class AviaQidirish : Fragment() {




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.aviaIzlash.setOnClickListener {
            startActivity(Intent(context,AviaIzlash::class.java))
        }
        binding.aviaQayerdan.setOnClickListener {
           startActivity(Intent(context,QayerdanAvia::class.java))
        }
        binding.aviaQayerga.setOnClickListener {
            startActivity(Intent(context,QayergaAvia::class.java))
        }
        binding.aviaQachon.setOnClickListener {
            val bottomDialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.dialog_bottom_sheet_calendar,null)
            bottomDialog.setContentView(view)
            bottomDialog.setTitle("sardor")
            bottomDialog.show()
        }
    }



    /*----------------Tegma----------------------*/
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

}