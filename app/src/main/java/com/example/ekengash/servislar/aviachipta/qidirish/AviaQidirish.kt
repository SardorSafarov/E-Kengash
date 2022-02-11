package com.example.ekengash.servislar.aviachipta.qidirish

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
import com.example.log.D


class AviaQidirish : Fragment() {

    private lateinit var nav: NavController


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.aviaQayerdan.setOnClickListener {
            D.d()
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