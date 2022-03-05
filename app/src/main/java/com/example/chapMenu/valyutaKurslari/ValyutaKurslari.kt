package com.example.chapMenu.valyutaKurslari

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ekengash.R
import com.example.ekengash.databinding.ActivityValyutaKurslariBinding
import com.example.log.D
import com.example.network.repository.KirishRepository
import com.example.network.repository.ValyutaRepository
import com.example.network.viewModelFactory.KirishViewModelFactory
import com.example.network.viewModelFactory.ValyutaViewModelFactory
import com.example.network.viewmodel.KirishViewModel
import com.example.network.viewmodel.ValyutaViewModel

class ValyutaKurslari : AppCompatActivity() {


    lateinit var binding:ActivityValyutaKurslariBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValyutaKurslariBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
        setUi()
        valyutaViewModel.valyuta()
        valyutaViewModel.valyuta.observe(this, Observer {
            D.d("keldi ${it.isSuccessful}")
            if (it.isSuccessful)
            {
                D.d("${it.body()!!.get(0)}")
            }
            else{
                D.d(it.errorBody()!!.toString())
            }
        })
    }

    private lateinit var valyutaViewModel: ValyutaViewModel
    private fun setUi() {
        val valyutaRepository = ValyutaRepository()
        val valyutaViewModelFactory = ValyutaViewModelFactory(valyutaRepository)
        val valyutaViewModel = ViewModelProvider(
            this,
            valyutaViewModelFactory
        ).get(ValyutaViewModel::class.java)
        this.valyutaViewModel = valyutaViewModel

    }
}