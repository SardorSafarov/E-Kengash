package com.example.ekengash.fragmentlar.kuproq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentKuproqBinding


class Kuproqq : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        topbuttonUzgartirish()
    }

    private fun topbuttonUzgartirish() {
        binding.kuproqTopButton1.setOnClickListener {
        }
        binding.kuproqTopButton2.setOnClickListener {

        }
    }


    /*---------------teginma---------------------------*/
    private var _binding: FragmentKuproqBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKuproqBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}