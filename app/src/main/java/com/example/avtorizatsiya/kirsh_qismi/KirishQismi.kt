package com.example.avtorizatsiya.kirsh_qismi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.avtorizatsiya.main.Kirish
import com.example.avtorizatsiya.ruyxatdan_utish.RuyxatdanUtish
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentAsosiy2Binding
import com.example.ekengash.databinding.FragmentKirishQismiBinding
import com.example.ekengash.main.MainActivity
import com.example.log.D


class KirishQismi : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.ruyxatdanUtish.setOnClickListener {
            requireFragmentManager().beginTransaction().replace(R.id.kirsh_qismidagi_fragment,RuyxatdanUtish()).commit()
        }
        binding.davomEtishButton.setOnClickListener {
            D.d(binding.telNumber.text.toString())
           // startActivity(Intent(context,MainActivity::class.java))
        }
    }




    /*----------------------Teginma------------------------------------*/
    private var _binding: FragmentKirishQismiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKirishQismiBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}