package com.example.servislar.tanggalar.tanggalardanFoydalanish

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.katrip.databinding.FragmentTanggalardanFoydalanishBinding
import com.example.servislar.tanggalar.turarJoy.TanggalarTurarJoy


class TanggalardanFoydalanish : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.tanggalarTurarjoy.setOnClickListener{
         startActivity(Intent(requireContext(),TanggalarTurarJoy::class.java))
        }
    }






    private var _binding: FragmentTanggalardanFoydalanishBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTanggalardanFoydalanishBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

}