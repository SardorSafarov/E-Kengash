package com.example.avtorizatsiya.ruyxatdan_utish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import com.example.avtorizatsiya.kirsh_qismi.KirishQismi
import com.example.avtorizatsiya.sms_kod_qismi.SmsniTasdiqlash
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentKirishQismiBinding
import com.example.ekengash.databinding.FragmentRuyxatdanUtishBinding
import com.example.log.D


class RuyxatdanUtish : Fragment() {



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        telNomerViewModel= ViewModelProviders.of(requireActivity()).get(TelNomerViewModel::class.java)

        teginma()



    }

    private fun teginma() {
        kirishgaQaytish()
        davomEtish()
    }


    /*===========================Teginma=========================*/
    private fun kirishgaQaytish() {
        binding.kirshgaQaytish.setOnClickListener {
            requireFragmentManager().beginTransaction().replace(R.id.kirsh_qismidagi_fragment,KirishQismi()).commit()
        }
    }

    private fun davomEtish() {
        binding.davomEtishButton.setOnClickListener {
            telNomerViewModel!!.telNomer(binding.telNumber.text.toString())
            requireFragmentManager().beginTransaction().replace(R.id.kirsh_qismidagi_fragment,SmsniTasdiqlash()).addToBackStack(null).commit()

        }
    }


    private var telNomerViewModel:TelNomerViewModel? = null
    private var _binding: FragmentRuyxatdanUtishBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRuyxatdanUtishBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}