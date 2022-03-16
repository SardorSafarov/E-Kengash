package com.example.ekengash.fragmentlar.kuproq.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentKuproqBinding
import com.example.ekengash.fragmentlar.kuproq.page1.KuproqItem1
import com.example.ekengash.fragmentlar.kuproq.page2.Kuproqitem2


class Kuproqq : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        topbuttonUzgartirish()
    }






    /*---------------Teginma---------------------------*/
    private var _binding: FragmentKuproqBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKuproqBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    private fun topbuttonUzgartirish() {
        childFragmentManager.beginTransaction().replace(R.id.kuproq_item_fragment, KuproqItem1())
            .commit()
        binding.kuproqTopButton1.setOnClickListener {
            topButtons(true)
            childFragmentManager.beginTransaction()
                .replace(R.id.kuproq_item_fragment, KuproqItem1()).commit()
        }
        binding.kuproqTopButton2.setOnClickListener {
            topButtons(false)
            childFragmentManager.beginTransaction()
                .replace(R.id.kuproq_item_fragment, Kuproqitem2()).commit()
        }
    }

    private fun topButtons(b: Boolean) {
        when (b) {
            true -> {
                binding.kuproqTopButton2.setImageResource(R.drawable.ic_kuproq_top_button_2)
                binding.kuproqTopButton1.setImageResource(R.drawable.ic_kuproq_top_button_1)
                binding.kuproqTopButton2.setBackgroundResource(R.drawable.kuproq_top_button_2)
                binding.kuproqTopButton1.setBackgroundResource(R.drawable.kuproq_top_button_1)
            }
            false -> {
                binding.kuproqTopButton2.setImageResource(R.drawable.ic_kuproq_top_button_2_0)
                binding.kuproqTopButton1.setImageResource(R.drawable.ic_kuproq_top_button_1_0)
                binding.kuproqTopButton2.setBackgroundResource(R.drawable.kuproq_top_button_1)
                binding.kuproqTopButton1.setBackgroundResource(R.drawable.kuproq_top_button_2)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}