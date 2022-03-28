package com.example.katrip.fragmentlar.explore.shaxarIchida.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constants.Constants.TOKEN
import com.example.katrip.databinding.ActivityShaxarIchidaBinding
import com.example.katrip.fragmentlar.explore.adapter.shaxarIchida.ShaxarIchidaAdapter
import com.example.katrip.fragmentlar.explore.shaxarIchida.page.ShaxarIchidaPage1
import com.example.log.D
import com.example.network.entity.explore.shaxarichi.ShaxarIchidaJavob
import com.example.network.entity.explore.shaxarlar.javob.ShaxarlarJavob
import com.example.network.repository.kirish.ExploreRepository
import com.example.network.viewModelFactory.explore.ExploreViewModelFactory
import com.example.network.viewmodel.explore.ExploreViewModel
import retrofit2.Response

class ShaxarIchida : AppCompatActivity(),ShaxarIchidaAdapter.onClickListener {
    lateinit var binding: ActivityShaxarIchidaBinding
    private lateinit var exploreViewModel: ExploreViewModel
    private val adapter:ShaxarIchidaAdapter by lazy { ShaxarIchidaAdapter(this,applicationContext) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShaxarIchidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUi()
        binding.shaxarNomi.setText(intent.getStringExtra("name"))
        statusBar()
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
        exploreViewModel.shaxarlarIchida(TOKEN,
            intent.getStringExtra("_id").toString(),
            "",
            intent.getStringExtra("til").toString())
        {
            if (it.isSuccessful) {
                binding.progersBar.visibility = View.GONE
                shaxar(it)
            }else
            {
                D.d("ShaxarIchida shaharlar false")
            }
        }
    }
    private fun shaxar(it: Response<ShaxarIchidaJavob>) {

            val s = it.body() as ShaxarIchidaJavob
            binding.apply {
                shaxarIchiRecycler.adapter = adapter
                shaxarIchiRecycler.layoutManager = LinearLayoutManager(this@ShaxarIchida)
            }
            adapter.getData(s.data.arr)
    }

    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }

    override fun shaxarIchidaOnClickListener() {
        val intentt = Intent(this, ShaxarIchidaPage1::class.java)

        intentt.putExtra("_id",intent.getStringExtra("_id").toString())
        intentt.putExtra("name",intent.getStringExtra("name"))
        intentt.putExtra("til",intent.getStringExtra("til").toString())
        startActivity(intentt)
    }
}