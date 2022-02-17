package com.example.avtorizatsiya.ruyxatdan_utish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.avtorizatsiya.kirsh_qismi.KirishQismi
import com.example.avtorizatsiya.sms_kod_qismi.SmsniTasdiqlash
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentKirishQismiBinding
import com.example.ekengash.databinding.FragmentRuyxatdanUtishBinding
import com.example.log.D


class RuyxatdanUtish : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.kirshgaQaytish.setOnClickListener {
            requireFragmentManager().beginTransaction().replace(R.id.kirsh_qismidagi_fragment,KirishQismi()).commit()
        }
        binding.davomEtishButton.setOnClickListener {

               requireFragmentManager().beginTransaction().replace(R.id.kirsh_qismidagi_fragment,SmsniTasdiqlash()).commit()

        }
    }


    /*----------------------Teginma------------------------------------*/
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