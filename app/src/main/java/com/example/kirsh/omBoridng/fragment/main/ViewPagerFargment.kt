package com.example.kirsh.omBoridng.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ekengash.databinding.FragmentViewPagerFargmentBinding
import com.example.kirsh.omBoridng.adapter.OnBoridingViewPageAdapter
import com.example.kirsh.omBoridng.fragment.birinchOyna.OnBordingBir
import com.example.kirsh.omBoridng.fragment.ikkinchOyna.IkkiOnBording
import com.example.kirsh.omBoridng.fragment.tilniTanlash.TilniTanlash
import com.example.kirsh.omBoridng.fragment.uchinchi.UchOnBording

class ViewPagerFargment : Fragment() {

    private var _binding: FragmentViewPagerFargmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewPagerFargmentBinding.inflate(inflater, container, false)
        val listfragment = arrayListOf<Fragment>(
            TilniTanlash(),
            OnBordingBir(),
            IkkiOnBording(),
            UchOnBording()
        )
        val adapter  = OnBoridingViewPageAdapter(listfragment,requireActivity().supportFragmentManager,lifecycle)
        binding.viewPager.adapter = adapter
        return    binding.root
    }


}