package com.example.kirsh.omBoridng.fragment.birinchOyna

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentOnBordingBirBinding


class OnBordingBir : Fragment() {

    private var _binding: FragmentOnBordingBirBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBordingBirBinding.inflate(inflater, container, false)
        val view = binding.root
        activity?.window?.statusBarColor = resources.getColor(R.color.white)
        binding.davomEtishButton.setOnClickListener{
            findNavController().navigate(R.id.action_onBordingBir_to_ikkiOnBording)
        }
        return view
    }
}