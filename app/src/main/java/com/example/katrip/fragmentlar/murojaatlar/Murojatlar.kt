package com.example.katrip.fragmentlar.murojaatlar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.katrip.databinding.FragmentMurojatlarBinding


class Murojatlar : Fragment() {






    ////------------------------Teginma-------------------------------------------/////
    private var _binding: FragmentMurojatlarBinding?=null
    private val binding: FragmentMurojatlarBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMurojatlarBinding.inflate(inflater,container,false)
        return binding.root
    }


}