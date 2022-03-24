package com.example.servislar.chiptalarim.haqida

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.constants.Constants
import com.example.ekengash.databinding.ActivityChatHaqidaBinding
import com.example.ekengash.databinding.ActivityChiptalarimHaqidaBinding
import com.example.ekengash.databinding.ActivitySaqlanganlarHaqidaBinding
import com.example.network.endtity.info.javob.INFO
import com.example.network.repository.kupBeriladiganSavollar.KupBeriladiganSavollarRepository
import com.example.network.viewModelFactory.kupBeriladiganSavollar.KupBeriladiganSavollarViewModelFactory
import com.example.network.viewmodel.kupBeriladiganSavollar.KupBeriladiganSavollarViewModel

class ChiptalarimHaqida : AppCompatActivity() {
    lateinit var binding: ActivityChiptalarimHaqidaBinding
    private lateinit var kupBeriladiganSavollarViewModel: KupBeriladiganSavollarViewModel
    private lateinit var list:List<INFO>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiptalarimHaqidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbar()
        ortgaQaytish()
        setUi()
        info()
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
    fun info() {
        kupBeriladiganSavollarViewModel.info(Constants.TOKEN,"uz") {
            if (it.isSuccessful) {
                binding.progersBar.visibility = View.GONE
                list = it.body()!!.data.INFO
                infoFilter("tickets")
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