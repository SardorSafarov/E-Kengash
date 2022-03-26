package com.example.kirsh.omBoridng.fragment.uchinchi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.constants.Constants
import com.example.kirsh.avtorizatsiya.main.Kirish
import com.example.katrip.R
import com.example.katrip.databinding.FragmentUchOnBordingBinding


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
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        til()
//    }
//    private fun til() {
//        when (Constants.TIL) {
//            "uz" -> {
//                binding.title.setText(title[2])
//                binding.subTitle.setText(sub_title[2])
//                binding.btnText.setText(button[3])
//            }
//            "ru" -> {
//                binding.title.setText(title[5])
//                binding.subTitle.setText(sub_title[5])
//                binding.btnText.setText(button[4])
//
//            }
//            "en" -> {
//                binding.title.setText(title[8])
//                binding.subTitle.setText(sub_title[8])
//                binding.btnText.setText(button[5])
//
//            }
//        }
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        title = resources.getStringArray(R.array.on_bording_title)
//        sub_title = resources.getStringArray(R.array.on_bording_subtitle)
//        button = resources.getStringArray(R.array.on_bording_tugmalar)
//    }
    private fun onBordingFinish()
    {
        val v1=requireActivity().getSharedPreferences("onBording",Context.MODE_PRIVATE)
        val v2 = v1.edit()
        v2.putBoolean("tugadi",true)
        v2.apply()
    }
}