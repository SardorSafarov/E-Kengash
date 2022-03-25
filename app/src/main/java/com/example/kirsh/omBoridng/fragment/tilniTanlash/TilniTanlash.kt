package com.example.kirsh.omBoridng.fragment.tilniTanlash

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.constants.Constants.SHAREDPREF_KEY
import com.example.constants.Constants.TIL
import com.example.katrip.R
import com.example.katrip.databinding.FragmentTilniTanlashBinding


class TilniTanlash : Fragment() {
    private var _binding: FragmentTilniTanlashBinding? = null
    private val binding get() = _binding!!
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTilniTanlashBinding.inflate(inflater, container, false)
        val view = binding.root
        setOnClickListener()
        sharedPreferences = activity?.getSharedPreferences(SHAREDPREF_KEY, MODE_PRIVATE)!!
        activity?.window?.statusBarColor = resources.getColor(R.color.asosiy_orqa_ranggi)

        return view
    }

    private fun setOnClickListener() {
        binding.tilUz.setOnClickListener{
            findNavController().navigate(R.id.action_tilniTanlash_to_onBordingBir)
            sharedPreferences.edit().apply{
            putString("til","uz")
            }.apply()
            TIL="uz"
        }
        binding.tilRu.setOnClickListener{
            findNavController().navigate(R.id.action_tilniTanlash_to_onBordingBir)
            TIL="ru"
            sharedPreferences.edit().apply{
                putString("til","ru")
            }.apply()
        }
        binding.tilEn.setOnClickListener{
            findNavController().navigate(R.id.action_tilniTanlash_to_onBordingBir)
            TIL="en"
            sharedPreferences.edit().apply{
                putString("til","en")
            }.apply()
        }
    }

}