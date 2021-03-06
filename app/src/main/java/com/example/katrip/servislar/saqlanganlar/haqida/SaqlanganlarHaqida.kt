package com.example.katrip.servislar.saqlanganlar.haqida

import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.constants.Constants
import com.example.katrip.databinding.ActivitySaqlanganlarHaqidaBinding
import com.example.network.entity.info.javob.INFO
import com.example.network.repository.kupBeriladiganSavollar.KupBeriladiganSavollarRepository
import com.example.network.viewModelFactory.kupBeriladiganSavollar.KupBeriladiganSavollarViewModelFactory
import com.example.network.viewmodel.kupBeriladiganSavollar.KupBeriladiganSavollarViewModel

class SaqlanganlarHaqida : AppCompatActivity() {
    lateinit var binding: ActivitySaqlanganlarHaqidaBinding
    private lateinit var kupBeriladiganSavollarViewModel: KupBeriladiganSavollarViewModel
    private lateinit var list:List<INFO>
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(Constants.LocalTilKey, MODE_PRIVATE)
        binding = ActivitySaqlanganlarHaqidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbar()
        ortgaQaytish()
        setUi()
        info(sharedPreferences.getString("til","ru").toString())
    }

    private fun setUi() {
        val kupBeriladiganSavollarRepository = KupBeriladiganSavollarRepository()
        val kupBeriladiganSavollarViewModelFactory =
            KupBeriladiganSavollarViewModelFactory(kupBeriladiganSavollarRepository)
        val kupBeriladiganSavollarViewModel = ViewModelProvider(
            this,
            kupBeriladiganSavollarViewModelFactory
        ).get(KupBeriladiganSavollarViewModel::class.java)
        this.kupBeriladiganSavollarViewModel = kupBeriladiganSavollarViewModel
    }
    fun info(toString: String) {
        kupBeriladiganSavollarViewModel.info(Constants.TOKEN,toString) {
            if (it.isSuccessful) {
                binding.progersBar.visibility = View.GONE
                list = it.body()!!.data.INFO
                infoFilter("saved")
            }
        }
    }


    fun infoFilter(faq_type:String)
    {
        var faqList:MutableList<INFO> = mutableListOf()
        list.forEach {
            if(it.type == faq_type)
                faqList.add(it)
        }
        binding.ofertaText.setText(faqList.get(0).value)
    }
    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }

    private fun statusbar() {
        window.statusBarColor = Color.WHITE
    }
}