package com.example.chapMenu.kupBeriladiganSavollar.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.asosiyQidirishOynasi.AsosiyQidirish
import com.example.chapMenu.kupBeriladiganSavollar.adapter.KupBeriladiganSavollarAdapter
import com.example.chapMenu.kupBeriladiganSavollar.adapter.KupBeriladiganSavollarKategoriyaAdapter
import com.example.constants.Constants.TOKEN
import com.example.ekengash.databinding.ActivityKupBeriladiganSavollarBinding
import com.example.log.D
import com.example.network.netWorkEndtity.kupBeriladiganSavollar.javob.FAQ
import com.example.network.netWorkEndtity.kupBeriladiganSavollar.javob.FAQTYPE
import com.example.network.netWorkEndtity.kupBeriladiganSavollar.javob.KupBeriladiganSavollarJavob
import com.example.network.repository.kupBeriladiganSavollar.KupBeriladiganSavollarRepository
import com.example.network.viewModelFactory.kupBeriladiganSavollar.KupBeriladiganSavollarViewModelFactory
import com.example.network.viewmodel.kupBeriladiganSavollar.KupBeriladiganSavollarViewModel
import retrofit2.Response

class KupBeriladiganSavollar : AppCompatActivity() {
    lateinit var binding:ActivityKupBeriladiganSavollarBinding
    private lateinit var kupBeriladiganSavollarViewModel:KupBeriladiganSavollarViewModel
    private val kupBeriladiganSavollarKategoriyaAdapter:KupBeriladiganSavollarKategoriyaAdapter by lazy { KupBeriladiganSavollarKategoriyaAdapter() }
    private val kupBeriladiganSavollarAdapter:KupBeriladiganSavollarAdapter by lazy { KupBeriladiganSavollarAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKupBeriladiganSavollarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        qidirish()
        ortgaQaytish()
        statusbar()
        setUi()
        savollar()
    }

    private fun savollar() {
        kupBeriladiganSavollarViewModel.KupBeriladiganSavollarViewModel(TOKEN){
            kupBeriladiganSavollar(it)
        }
    }

    private fun kupBeriladiganSavollar(response: Response<KupBeriladiganSavollarJavob>) {
        if(response.isSuccessful)
        {
            binding.progress.visibility = View.GONE
            D.d(response.body().toString())
            savollarkategoriya(response.body()!!.data.FAQ_TYPE)
            savollarVaJavoblar(response.body()!!.data.FAQ)
        }
    }

    private fun savollarVaJavoblar(faq: List<FAQ>) {
        kupBeriladiganSavollarAdapter.setData(faq)
        binding.savollar.adapter = kupBeriladiganSavollarAdapter
        binding.savollar.layoutManager = LinearLayoutManager(this)
    }

    private fun savollarkategoriya(faqType: List<FAQTYPE>) {
            kupBeriladiganSavollarKategoriyaAdapter.setData(faqType)
            binding.savolKategoriya.adapter = kupBeriladiganSavollarKategoriyaAdapter
            binding.savolKategoriya.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    private fun setUi() {
        val kupBeriladiganSavollarRepository = KupBeriladiganSavollarRepository()
        val kupBeriladiganSavollarViewModelFactory = KupBeriladiganSavollarViewModelFactory(kupBeriladiganSavollarRepository)
        val kupBeriladiganSavollarViewModel = ViewModelProvider(
            this,
            kupBeriladiganSavollarViewModelFactory
        ).get(KupBeriladiganSavollarViewModel::class.java)
        this.kupBeriladiganSavollarViewModel = kupBeriladiganSavollarViewModel

    }

    private fun statusbar() {
        window.statusBarColor = Color.WHITE
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }

    private fun qidirish() {
        binding.qidirsh.setOnClickListener {
            startActivity(Intent(this,AsosiyQidirish::class.java))
        }
    }
}