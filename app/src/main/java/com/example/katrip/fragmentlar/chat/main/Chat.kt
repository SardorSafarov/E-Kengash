package com.example.katrip.fragmentlar.chat.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.katrip.databinding.FragmentChatBinding
import com.example.katrip.fragmentlar.chat.chatHaqida.ChatHaqida

class Chat : Fragment() {
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    private val GALLERY_REQUEST = 2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        chatHaqida()
        fileJunatish()
        val view = binding.root
        return view
    }

    private fun fileJunatish() {
        binding.fileJunatish.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,GALLERY_REQUEST)
        }
    }

    private fun chatHaqida() {
        binding.chatHaqida.setOnClickListener {
            startActivity(Intent(requireContext(),ChatHaqida::class.java))
        }
    }


}