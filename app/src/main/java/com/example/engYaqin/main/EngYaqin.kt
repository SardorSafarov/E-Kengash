package com.example.engYaqin.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constants.Constants
import com.example.engYaqin.adapter.EngYaqinKategoriyaAdapter
import com.example.engYaqin.adapter.KategoriyaViewAdapter
import com.example.katrip.databinding.ActivityEngYaqinBinding
import com.example.engYaqin.haqida.EngYaqinHaqida
import com.example.log.D
import com.example.network.entity.explore.engYaqin.Arr
import com.example.network.entity.explore.engYaqin.EngYaqinJavob
import com.example.network.repository.kirish.ExploreRepository
import com.example.network.viewModelFactory.explore.ExploreViewModelFactory
import com.example.network.viewmodel.explore.ExploreViewModel
import retrofit2.Response

class EngYaqin : AppCompatActivity(), EngYaqinKategoriyaAdapter.kategoriyaBtn,KategoriyaViewAdapter.kategoriyaView {


    private lateinit var binding: ActivityEngYaqinBinding
    private lateinit var exploreViewModel: ExploreViewModel
    private val adapter: EngYaqinKategoriyaAdapter by lazy { EngYaqinKategoriyaAdapter(this) }
    private val adapterKategoriyaViewAdapter: KategoriyaViewAdapter by lazy { KategoriyaViewAdapter(this,applicationContext) }
    private lateinit var listkategoriya:MutableList<Arr>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEngYaqinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBar()
        ortgaQaytish()
        haqida()
        setUi()
        shaxarniOlish()
    }

    private fun setUi() {
        val exploreRepository = ExploreRepository()
        val expViewModelFactory = ExploreViewModelFactory(exploreRepository)
        val exploreViewModel = ViewModelProvider(
            this,
            expViewModelFactory
        ).get(ExploreViewModel::class.java)
        this.exploreViewModel = exploreViewModel
    }

    private fun shaxarniOlish() {
        exploreViewModel.engYaqinKategoriiyaBtn(Constants.TOKEN,
            "1",
            "10")
        {
            if (it.isSuccessful) {
                binding.apply {
                    mani.visibility = View.VISIBLE
                    progress.visibility = View.GONE
                }
                kategoriya(it)
            } else {
                D.d("ShaxarIchida shaharlar false")
            }
        }
    }

    private fun kategoriya(response: Response<EngYaqinJavob>) {
        binding.apply {
            kategoriyaBtn.adapter = adapter
            kategoriyaBtn.layoutManager =
                LinearLayoutManager(this@EngYaqin, LinearLayoutManager.HORIZONTAL, false)
        }
        adapter.setData(response.body()!!.data.category)
        listkategoriya = response.body()!!.data.arr as MutableList<Arr>
        kategoriyaView(response.body()!!.data.arr)
    }

    private fun kategoriyaView(arr: List<Arr>) {
        binding.apply {
            kategoriyaView.adapter = adapterKategoriyaViewAdapter
            kategoriyaView.layoutManager = LinearLayoutManager(this@EngYaqin)
        }
        adapterKategoriyaViewAdapter.setData(arr)
    }


    override fun onclick(type: Int) {
        val arr:MutableList<Arr> = mutableListOf()
        listkategoriya.forEach {
            if(it.explore_category_id == type)
                arr.add(it)
        }
        binding.apply {
            kategoriyaView.adapter = adapterKategoriyaViewAdapter
            kategoriyaView.layoutManager = LinearLayoutManager(this@EngYaqin)
        }
        adapterKategoriyaViewAdapter.setData(arr)
    }

    private fun haqida() {
        binding.engYaqinHaqida.setOnClickListener {
            startActivity(Intent(this, EngYaqinHaqida::class.java))
        }
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }

    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }

    override fun onclickView(type: String) {
        TODO("Not yet implemented")
    }
}