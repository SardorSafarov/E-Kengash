package com.example.chapMenu.profil.shaxsiy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.shaxsiyMalumotlar.ShaxsiyMalumotlar
import com.example.ekengash.databinding.FragmentProfilShaxsiyBinding


class ProfilShaxsiy : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shaxsiyProfilniTasdiqlash()
    }

    private fun shaxsiyProfilniTasdiqlash() {
        binding.shaxsiyProfilniTasdiqlash.setOnClickListener {
            startActivity(Intent(requireContext(), ShaxsiyMalumotlar::class.java))
        }
    }


    private var _binding: FragmentProfilShaxsiyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilShaxsiyBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}