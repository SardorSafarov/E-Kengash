package com.example.chapMenu.valyutaKurslari

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapMenu.adapter.ValyutaKurslariAdapter
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

  lateinit var adapterValyuta:ValyutaKurslariAdapter

    lateinit var binding:ActivityValyutaKurslariBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValyutaKurslariBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        adapterValyuta = ValyutaKurslariAdapter()
        setUi()

        binding.recyclerViewValyuta.adapter = adapterValyuta
        binding.recyclerViewValyuta.layoutManager = LinearLayoutManager(this)


        valyutaViewModel.valyuta()
        valyutaViewModel.valyuta.observe(this, Observer {
            if (it.isSuccessful)
            {
               adapterValyuta.setData(it.body()!!)
            }
            else{
                D.d("${it.errorBody()!!} ValyutaKurslari  valuate.observe da")
            }
        })
        ortgaQaytish()
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
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