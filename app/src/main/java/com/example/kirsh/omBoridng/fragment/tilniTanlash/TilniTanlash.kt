package com.example.kirsh.omBoridng.fragment.tilniTanlash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentTilniTanlashBinding


class TilniTanlash : Fragment() {
    private var _binding: FragmentTilniTanlashBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTilniTanlashBinding.inflate(inflater, container, false)
        val view = binding.root
        activity?.window?.statusBarColor = resources.getColor(R.color.asosiy_orqa_ranggi)
       binding.tilUz.setOnClickListener{
           findNavController().navigate(R.id.action_tilniTanlash_to_onBordingBir)
       }
        binding.tilRu.setOnClickListener{
            findNavController().navigate(R.id.action_tilniTanlash_to_onBordingBir)
        }
        binding.tilEn.setOnClickListener{
            findNavController().navigate(R.id.action_tilniTanlash_to_onBordingBir)
        }
        return view
    }

}