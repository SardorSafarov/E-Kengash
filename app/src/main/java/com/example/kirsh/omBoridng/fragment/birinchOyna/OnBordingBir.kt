package com.example.kirsh.omBoridng.fragment.birinchOyna

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.constants.Constants.LocalTilKey
import com.example.katrip.R
import com.example.katrip.databinding.FragmentOnBordingBirBinding
import com.example.log.D


class OnBordingBir : Fragment() {
    private var _binding: FragmentOnBordingBirBinding? = null
    private val binding get() = _binding!!
    lateinit var sharedPreferences: SharedPreferences
    lateinit var lan: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentOnBordingBirBinding.inflate(inflater, container, false)
        val view = binding.root
        activity?.window?.statusBarColor = resources.getColor(R.color.white)
        binding.davomEtishButton.setOnClickListener {
            findNavController().navigate(R.id.action_onBordingBir_to_ikkiOnBording)
        }
        sharedPreferences = requireActivity().getSharedPreferences(LocalTilKey, AppCompatActivity.MODE_PRIVATE)
        lan = sharedPreferences.getString("til", "default").toString()
        D.d(lan)
        return view
    }





}