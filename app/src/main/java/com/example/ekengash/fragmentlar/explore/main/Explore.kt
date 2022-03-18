package com.example.ekengash.fragmentlar.explore.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asosiyQidirishOynasi.AsosiyQidirish
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentExploreBinding
import com.example.ekengash.databinding.FragmentKuproqBinding


class Explore : Fragment() {
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val view = binding.root
        qidrish()
        return view
    }

    private fun qidrish() {
        binding.qidirsh.setOnClickListener {
            startActivity(Intent(requireContext(),AsosiyQidirish::class.java))
        }
    }


}