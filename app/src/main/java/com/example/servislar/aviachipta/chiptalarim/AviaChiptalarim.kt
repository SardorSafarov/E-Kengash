package com.example.servislar.aviachipta.chiptalarim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ekengash.databinding.FragmentAviaChiptalarimBinding

class AviaChiptalarim : Fragment() {



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    /*----------------Tegma----------------------*/
    private var _binding: FragmentAviaChiptalarimBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAviaChiptalarimBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

}