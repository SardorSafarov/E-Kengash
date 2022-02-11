package com.example.ekengash.servislar.aviachipta.chiptalarim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentAviaChiptalarimBinding
import com.example.ekengash.databinding.FragmentAviaQidirishBinding

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