package com.example.avtorizatsiya.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.avtorizatsiya.kirsh_qismi.KirishQismi
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityKirishBinding
import com.example.log.D
import com.example.network.repository.KirishRepository
import com.example.network.viewModelFactory.KirishViewModelFactory
import com.example.network.viewmodel.KirishViewModel


class Kirish : AppCompatActivity() {
    // Bislillahir rohimanir rohim
    private lateinit var kirishViewModel: KirishViewModel
    private var checkUser=""
    private fun setUi() {
        val kirishRepository = KirishRepository()
        val kirishViewModelFactory = KirishViewModelFactory(kirishRepository)
        val kirishViewModel = ViewModelProvider(
            this,
            kirishViewModelFactory
        ).get(KirishViewModel::class.java)
        this.kirishViewModel=kirishViewModel
        supportFragmentManager.beginTransaction().replace(R.id.kirsh_qismidagi_fragment,KirishQismi()).commit()
    }
    fun telJunatish(){
        binding.davomEtishButton.setOnClickListener {
            when(checkUser){
                ""->{
                    kirishViewModel.telJunatish("998"+binding.telNumber.text.toString())
                }
                "Yes"->{
                    kirishViewModel.telJunatish("998"+binding.telNumber.text.toString())
                }
                "No"->{
                    kirishViewModel.telJunatish("998"+binding.telNumber.text.toString())
                }
            }

        }
        kirishViewModel.telJunatish.observe(this, Observer {
            if (it.isSuccessful) {
                binding.kirish.visibility=View.INVISIBLE
                binding.kirishRuyxatdanUtish.visibility=View.INVISIBLE
                checkUser=it.body()!!.data.check
                if(checkUser=="Yes")
                {
                    binding.kirish.visibility=View.VISIBLE
                }
                else
                {
                    binding.kirishRuyxatdanUtish.visibility=View.VISIBLE
                }
            }
            else{
                D.d("ishlamadi")
            }


        })
    }


    /*------------------------------------------------Teginma-------------------------------------------------------------------------------------*/

    lateinit var binding: ActivityKirishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKirishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        teginma()
        setUi()
      //  telJunatish()
    }

    private fun teginma() {
        statusbar()
    }

    private fun statusbar() {
        window.statusBarColor = Color.WHITE
    }
}