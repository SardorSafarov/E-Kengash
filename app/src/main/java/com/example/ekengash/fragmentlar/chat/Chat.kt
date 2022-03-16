package com.example.ekengash.fragmentlar.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentChatBinding
import com.example.ekengash.databinding.FragmentKuproqitem2Binding

class Chat : Fragment() {
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}