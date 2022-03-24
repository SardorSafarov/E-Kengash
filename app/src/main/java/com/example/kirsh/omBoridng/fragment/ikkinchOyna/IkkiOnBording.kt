package com.example.kirsh.omBoridng.fragment.ikkinchOyna

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.constants.Constants
import com.example.katrip.R
import com.example.katrip.databinding.FragmentIkkiOnBordingBinding


class IkkiOnBording : Fragment() {

    private var _binding: FragmentIkkiOnBordingBinding? = null
    private val binding get() = _binding!!
    lateinit var title: Array<String>
    lateinit var sub_title: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIkkiOnBordingBinding.inflate(inflater, container, false)
        val view = binding.root
        activity?.window?.statusBarColor = resources.getColor(R.color.white)
        binding.davomEtishButton.setOnClickListener{
            findNavController().navigate(R.id.action_ikkiOnBording_to_uchOnBording)
        }
        return view
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        til()
    }
    private fun til() {
        when (Constants.TIL) {
            "uz" -> {
                binding.title.setText(title[1])
                binding.subTitle.setText(sub_title[1])
            }
            "ru" -> {
                binding.title.setText(title[4])
                binding.subTitle.setText(sub_title[4])

            }
            "en" -> {
                binding.title.setText(title[7])
                binding.subTitle.setText(sub_title[7])

            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        title = resources.getStringArray(R.array.on_bording_title)
        sub_title = resources.getStringArray(R.array.on_bording_subtitle)
    }
}