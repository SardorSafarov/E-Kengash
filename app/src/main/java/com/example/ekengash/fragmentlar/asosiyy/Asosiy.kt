package com.example.ekengash.fragmentlar.asosiyy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentAsosiy2Binding
import com.example.ekengash.databinding.FragmentKuproqBinding
import com.example.ekengash.fragmentlar.asosiy_qidirish_oynasi.AsosiyQidirish


class Asosiy : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        asosiyQidirishOynasi()
    }




    /*--------------------------------------Teginma-------------------------------------------------------------*/
    private fun asosiyQidirishOynasi() {
        binding.asosiyQidirishButton.setOnClickListener {
            startActivity(Intent(context,AsosiyQidirish::class.java))
        }
    }
    private var _binding: FragmentAsosiy2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAsosiy2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}