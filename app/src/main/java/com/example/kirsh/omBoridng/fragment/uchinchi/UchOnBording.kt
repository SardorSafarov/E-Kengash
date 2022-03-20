package com.example.kirsh.omBoridng.fragment.uchinchi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kirsh.avtorizatsiya.main.Kirish
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentUchOnBordingBinding


class UchOnBording : Fragment() {
    private var _binding: FragmentUchOnBordingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUchOnBordingBinding.inflate(inflater, container, false)
        val view = binding.root
        activity?.window?.statusBarColor = resources.getColor(R.color.white)
        binding.davomEtishButton.setOnClickListener{
            onBordingFinish()
            startActivity(Intent(requireContext(), Kirish::class.java))
            activity?.finish()
        }
        return view
    }
    private fun onBordingFinish()
    {
        val v1=requireActivity().getSharedPreferences("onBording",Context.MODE_PRIVATE)
        val v2 = v1.edit()
        v2.putBoolean("tugadi",true)
        v2.apply()
    }
}