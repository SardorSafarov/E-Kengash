package com.example.chapMenu.valyutaKurslari.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.asosiyQidirishOynasi.AsosiyQidirish
import com.example.chapMenu.valyutaKurslari.adapter.ValyutaKurslariAdapter
import com.example.katrip.databinding.ActivityValyutaKurslariBinding
import com.example.log.D
import com.example.network.endtity.valyuta.ValyutaEntity
import com.example.network.repository.valyuta.ValyutaRepository
import com.example.network.viewModelFactory.valyuta.ValyutaViewModelFactory
import com.example.network.viewmodel.valyuta.ValyutaViewModel
import retrofit2.Response

class ValyutaKurslari : AppCompatActivity() {
    lateinit var binding: ActivityValyutaKurslariBinding
    private lateinit var valyutaViewModel: ValyutaViewModel
    lateinit var adapterValyuta: ValyutaKurslariAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValyutaKurslariBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBar()
        setUi()
        valyutaAdapterInit()
        ortgaQaytish()
        qidirish()
    }

    private fun qidirish() {
        binding.qidirsh.setOnClickListener {
            startActivity(Intent(this,AsosiyQidirish::class.java))
        }
    }

    private fun valyutaAdapterInit() {
        adapterValyuta = ValyutaKurslariAdapter()
        binding.recyclerViewValyuta.adapter = adapterValyuta
        binding.recyclerViewValyuta.layoutManager = LinearLayoutManager(this)
        valyutaViewModel.valyuta({valyutaResponse(it)})
    }

    private fun setUi() {
        val valyutaRepository = ValyutaRepository()
        val valyutaViewModelFactory = ValyutaViewModelFactory(valyutaRepository)
        val valyutaViewModel = ViewModelProvider(
            this,
            valyutaViewModelFactory
        ).get(ValyutaViewModel::class.java)
        this.valyutaViewModel = valyutaViewModel

    }

    private fun valyutaResponse(response: Response<ValyutaEntity>) {
        if(response.isSuccessful)
        {
            adapterValyuta.setData(response.body()!!)
        }
        else {
            D.d("${response.errorBody()!!} ValyutaKurslari  valyutaResponse da")
        }
    }
    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }



}