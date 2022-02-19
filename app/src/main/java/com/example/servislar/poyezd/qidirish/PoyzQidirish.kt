package com.example.servislar.poyezd.qidirish

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ekengash.databinding.FragmentPoyzQidirishBinding
import com.example.servislar.poyezd.izlash.PoyezdIzlash


class PoyzQidirish : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.aviaQayerdan.setOnClickListener {
            //startActivity(Intent(context, QayerdanAvia::class.java))
        }
        binding.aviaQayerga.setOnClickListener {
           //startActivity(Intent(context, QayergaAvia::class.java))
        }
        binding.poyezdIzlash.setOnClickListener {
            startActivity(Intent(context,PoyezdIzlash::class.java))
        }
    }



    /*----------------Tegma----------------------*/
    private var _binding: FragmentPoyzQidirishBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPoyzQidirishBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}