package com.example.servislar.turarJoylar.qidirish.izlash

import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constants.Constants.LocalTilKey
import com.example.constants.Constants.TOKEN
import com.example.katrip.databinding.ActivityTurarJoyIzlashBinding
import com.example.log.D
import com.example.network.entity.turarJoy.izlash.Arr
import com.example.network.repository.turarJoy.TurarJoyRepository
import com.example.network.viewModelFactory.turarJoy.TurarJoyViewModelFactory
import com.example.network.viewmodel.turarJoy.TurarJoyViewModel
import com.example.servislar.turarJoylar.adapter.IzlanganTurarJoyAdapter

class TurarJoyIzlash : AppCompatActivity(),IzlanganTurarJoyAdapter.izlanganTurarJoySetOnClickListener {
    private lateinit var binding: ActivityTurarJoyIzlashBinding
    private lateinit var turarJoyViewModel: TurarJoyViewModel
    private lateinit var sharedPreferences: SharedPreferences
    private val izlanganTurarJoyAdapter:IzlanganTurarJoyAdapter by lazy { IzlanganTurarJoyAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurarJoyIzlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            shaxarNomi.setText(intent.getStringExtra("shaxar").toString())
            holat.setText(intent.getStringExtra("xona").toString()+" xona | "+intent.getStringExtra("kishi").toString()+" kishi")
        }
        sharedPreferences = getSharedPreferences(LocalTilKey, MODE_PRIVATE)
        statusBar()
        turarJoySetUi()
        turarJoyniOlish()
        ortgaQaytish()
    }

    private fun ortgaQaytish() {
        binding.imageView4.setOnClickListener {
            finish()
        }
    }


    private fun turarJoySetUi() {
        val turarJoyRepository = TurarJoyRepository()
        val turarJoyViewModelFactory = TurarJoyViewModelFactory(turarJoyRepository)
        turarJoyViewModel =
            ViewModelProvider(this, turarJoyViewModelFactory).get(TurarJoyViewModel::class.java)
    }


    private fun turarJoyniOlish() {
        var til = ""
        if (sharedPreferences.getString("til", "uz").toString() == "en-us") {
            til = "uz"
        } else {
            til = sharedPreferences.getString("til", "uz").toString()
        }
        turarJoyViewModel.taxiManzilQidirish(TOKEN,
            intent.getStringExtra("katta").toString(),
            intent.getStringExtra("bolalar").toString(),
            intent.getStringExtra("shaxar").toString(),
            til
        ) {
            if (it.isSuccessful) {
                binding.progress.visibility = View.GONE
                D.d(it.body().toString())
                turarJoylar(it.body()!!.data.arr)
            }
        }
    }

    private fun turarJoylar(arr: List<Arr>) {
            binding.apply {
                turarJoyRecycler.adapter = izlanganTurarJoyAdapter
                turarJoyRecycler.layoutManager = LinearLayoutManager(this@TurarJoyIzlash)
            }
            izlanganTurarJoyAdapter.setData(arr)
    }

    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }

    override fun izlanganTurarJoySetOnClickListener(id: Int) {

    }
}