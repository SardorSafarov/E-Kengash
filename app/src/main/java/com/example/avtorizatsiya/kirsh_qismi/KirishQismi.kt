package com.example.avtorizatsiya.kirsh_qismi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.avtorizatsiya.ruyxatdan_utish.RuyxatdanUtish
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentKirishQismiBinding
import com.example.ekengash.main.MainActivity
import com.example.log.D
import com.example.network.netWorkEndtity.kirsh.parolniTekshirish.surov.ParolniTekshirishSurov
import com.example.network.repository.KirishRepository
import com.example.network.viewModelFactory.KirishViewModelFactory
import com.example.network.viewmodel.KirishViewModel


class KirishQismi : Fragment() {


    private lateinit var kirishViewModel: KirishViewModel
    private var checkUser = ""
    private fun setUi() {
        val kirishRepository = KirishRepository()
        val kirishViewModelFactory = KirishViewModelFactory(kirishRepository)
        val kirishViewModel = ViewModelProvider(
            this,
            kirishViewModelFactory
        ).get(KirishViewModel::class.java)
        this.kirishViewModel = kirishViewModel

    }

    fun telJunatish() {
        binding.davomEtishButton.setOnClickListener {
            if(binding.parol.text.toString().isNotEmpty())
            {
                kirishViewModel.parolniTekshirish(ParolniTekshirishSurov(
                    password = binding.parol.text.toString().trim(),
                    username ="998"+binding.telNumber.text.toString()
                ))
                kirishViewModel.parolniTekshirish.observe(viewLifecycleOwner, Observer {
                    if (it.isSuccessful){
                        if(it.body()!!.status=="success")
                        {
                            startActivity(Intent(requireContext(),MainActivity::class.java))
                            activity?.finish()

                        }
                        else
                        {
                            binding.textView24r.setText("Parol xato!!")

                        }

                    }else
                    {
                        D.d("KirishQismi parolniTekshirishga qara")
                    }
                })
            }
            else {
                when (checkUser) {
                    "" -> {
                        kirishViewModel.telJunatish("998" + binding.telNumber.text.toString())
                    }
                    "Yes" -> {
                        kirishViewModel.telJunatish("998" + binding.telNumber.text.toString())
                    }
                    "No" -> {
                        kirishViewModel.telJunatish("998" + binding.telNumber.text.toString())
                    }
                }
            }
        }
        kirishViewModel.telJunatish.observe(requireActivity(), Observer {
            if (it.isSuccessful) {
                checkUser = it.body()!!.data.check
                if (checkUser == "Yes") {
                    binding.linearLayout7r.visibility = View.VISIBLE
                    binding.textView24r.visibility = View.VISIBLE
                    binding.parolniUnutdinggizmi.visibility=View.VISIBLE
                    binding.textView24r.text="Parolni kiriting"
                } else {
                    binding.textView24r.visibility = View.VISIBLE
                    binding.linearLayout7r.visibility = View.INVISIBLE
                    binding.textView24r.text="Bunday Foydalanuvchi yo`q!"
                }
            } else {
                D.d("KirishQismi telJunatish ishlamadi")
            }


        })
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUi()
        telJunatish()
        binding.ruyxatdanUtish.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.kirsh_qismidagi_fragment, RuyxatdanUtish()).commit()
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