package com.example.kirsh.avtorizatsiya.ruyxatdanUtish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kirsh.avtorizatsiya.kirshQismi.KirishQismi
import com.example.katrip.R
import com.example.katrip.databinding.FragmentRuyxatdanUtishTuliqBinding
import com.example.log.D
import com.example.network.endtity.kirsh.ruyxatdanUtish.surov.RuyxatdanUtishSurov
import com.example.network.repository.kirish.KirishRepository
import com.example.network.viewModelFactory.kirish.KirishViewModelFactory
import com.example.network.viewmodel.kirish.KirishViewModel


class RuyxatdanUtishTuliq : Fragment() {
    private var _binding: FragmentRuyxatdanUtishTuliqBinding? = null
    private var telNomerViewModel:TelNomerViewModel?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRuyxatdanUtishTuliqBinding.inflate(inflater, container, false)
        setUi()
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        telNumberniOlish()
        ruyxatdanUtish()
        kirishViewModel.ruyxatdanUtish.observe(viewLifecycleOwner, Observer {
            if(it.isSuccessful)
            {
                if(it.body()!!.status=="redirect")
                {
                    fragmentManager?.beginTransaction()?.replace(R.id.kirsh_qismidagi_fragment,KirishQismi())?.commit()
                }
            }
            else{
                D.d("RuyxatdanUtishTuliq kirishViewModel ruyxatdanUtish ishlamadi!!!")
            }
        })
    }



    private fun ruyxatdanUtish() {
        binding.ruyxatdanUtishBtn.setOnClickListener {
            if (binding.parol11.text.toString().trim() == binding.parol22.text.toString().trim())
            {
                binding.parolXarXil.visibility = View.INVISIBLE
                kirishViewModel.ruyxatdanUtish(
                    RuyxatdanUtishSurov(
                        username = "998"+binding.telNumber.text.toString(),
                        password = binding.parol11.text.toString().trim(),
                        full_name = binding.foydalanuvchiIsmii.text.toString(),
                        phone = "998"+binding.telNumber.text.toString()
                    )
                )
            }else
            {
                binding.parolXarXil.visibility = View.VISIBLE
            }
        }
    }

    /*=========================Teginma============================================*/


    private lateinit var kirishViewModel: KirishViewModel
    private fun setUi() {
        val kirishRepository = KirishRepository()
        val kirishViewModelFactory = KirishViewModelFactory(kirishRepository)
        val kirishViewModel = ViewModelProvider(
            this,
            kirishViewModelFactory
        ).get(KirishViewModel::class.java)
        this.kirishViewModel = kirishViewModel

    }


    fun telNumber(telNumber: String) {
        binding.telNumber.text = telNumber
    }
    private fun telNumberniOlish() {
        telNomerViewModel= ViewModelProviders.of(requireActivity()).get(TelNomerViewModel::class.java)
        telNomerViewModel!!.telNomer.observe(viewLifecycleOwner,object :Observer<Any>{
            override fun onChanged(t: Any?) {
                telNumber(t.toString())
            }
        })
    }




}