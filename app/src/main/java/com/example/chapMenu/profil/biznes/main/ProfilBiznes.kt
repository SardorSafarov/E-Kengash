package com.example.chapMenu.profil.biznes.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chapMenu.profil.biznes.biznesProfilQushish.ProfilBiznesProfilQushish
import com.example.katrip.databinding.FragmentProfilBiznesBinding

class ProfilBiznes : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.biznesProfilQushish.setOnClickListener {
            startActivity(Intent(requireContext(),ProfilBiznesProfilQushish::class.java))
        }
    }
    private var _binding: FragmentProfilBiznesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilBiznesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}