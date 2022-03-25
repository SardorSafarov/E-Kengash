package com.example.kirsh.omBoridng.fragment.birinchOyna

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.constants.Constants.TIL
import com.example.katrip.R
import com.example.katrip.databinding.FragmentOnBordingBirBinding


class OnBordingBir : Fragment() {
    private var _binding: FragmentOnBordingBirBinding? = null
    private val binding get() = _binding!!
    lateinit var title: Array<String>
    lateinit var sub_title: Array<String>
    lateinit var button:Array<String>
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
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        til()
    }

    private fun til() {
        when (TIL) {
            "uz" -> {
                binding.title.setText(title[0])
                binding.subTitle.setText(sub_title[0])
                binding.btnText.setText(button[0])
            }
            "ru" -> {
                binding.title.setText(title[3])
                binding.subTitle.setText(sub_title[3])
                binding.btnText.setText(button[1])

            }
            "en" -> {
                binding.title.setText(title[6])
                binding.subTitle.setText(sub_title[6])
                binding.btnText.setText(button[2])
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        title = resources.getStringArray(R.array.on_bording_title)
        sub_title = resources.getStringArray(R.array.on_bording_subtitle)
        button = resources.getStringArray(R.array.on_bording_tugmalar)
    }
}