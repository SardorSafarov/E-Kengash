package com.example.servislar.taxi.taxiQidirish

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constants.Constants.TOKEN
import com.example.katrip.databinding.ActivityHaydovchiQidirishBinding
import com.example.log.D
import com.example.network.repository.surovNoma.SurovNomaRepository
import com.example.network.viewModelFactory.surovNoma.SurovNomaViewModelFactory
import com.example.network.viewmodel.surovNoma.SurovNomaViewModel
import com.example.servislar.taxi.adapter.haydovchiIzlash.HaydovchiIzlashAdapter

class HaydovchiQidirish : AppCompatActivity(),HaydovchiIzlashAdapter.kategoriyaView {
    private lateinit var binding: ActivityHaydovchiQidirishBinding
    private lateinit var vaqt: String
    private lateinit var qayerga: String
    private lateinit var ga_lat: String
    private lateinit var ga_lng: String
    private lateinit var qayerdan: String
    private lateinit var dan_lat: String
    private lateinit var dan_lng: String
    private lateinit var surovNomaViewModel: SurovNomaViewModel
    private val adapter:HaydovchiIzlashAdapter by lazy { HaydovchiIzlashAdapter(this, context = applicationContext) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHaydovchiQidirishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        setUi()
        manzilMalumotlari()
        haydovchiQidirish()
        ortgaQaytish()
        binding.apply {
            taxiRecycler.adapter = adapter
            taxiRecycler.layoutManager = LinearLayoutManager(this@HaydovchiQidirish)
        }
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }

    private fun setUi() {
        val surovNomaRepository = SurovNomaRepository()
        val surovNomaViewModelFactory = SurovNomaViewModelFactory(surovNomaRepository)
        val surovNomaViewModel = ViewModelProvider(
            this,
            surovNomaViewModelFactory
        ).get(SurovNomaViewModel::class.java)
        this.surovNomaViewModel = surovNomaViewModel
    }
    private fun haydovchiQidirish() {
        surovNomaViewModel.haydovchiIzlash(TOKEN,
            from_lat = dan_lat,
            from_lng = dan_lng,
            to_lat = ga_lat,
            to_lng = ga_lng,
            date = vaqt,
            from_place = "111111",
            to_place = "22222"
        ){
            if(it.isSuccessful) {
                binding.progress.visibility = View.GONE
                adapter.setData(it.body()!!.data.list)
            }
        }
    }

    private fun manzilMalumotlari() {
        vaqt = intent.getStringExtra("vaqt").toString()
        qayerga = intent.getStringExtra("qayerga").toString()
        ga_lat = intent.getStringExtra("ga_lat").toString()
        ga_lng = intent.getStringExtra("ga_lng").toString()
        qayerdan = intent.getStringExtra("qayerdan").toString()
        dan_lat = intent.getStringExtra("dan_lat").toString()
        dan_lng = intent.getStringExtra("dan_lng").toString()
    }

    override fun onclickView(type: String) {

    }
}