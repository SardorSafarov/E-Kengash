package com.example.avtorizatsiya.sms_kod_qismi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.avtorizatsiya.ruyxatdan_utish.RuyxatdanUtishTuliq
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentRuyxatdanUtishBinding
import com.example.ekengash.databinding.FragmentSmsniTasdiqlashBinding


class SmsniTasdiqlash : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.tasdiqlashButton.setOnClickListener {
            requireFragmentManager().beginTransaction().replace(R.id.kirsh_qismidagi_fragment,RuyxatdanUtishTuliq()).commit()
        }
    }





    private var _binding: FragmentSmsniTasdiqlashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSmsniTasdiqlashBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}