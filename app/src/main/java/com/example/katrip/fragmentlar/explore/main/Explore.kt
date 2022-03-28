package com.example.katrip.fragmentlar.explore.main

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.asosiyQidirishOynasi.AsosiyQidirish
import com.example.constants.Constants.LocalTilKey
import com.example.constants.Constants.TOKEN
import com.example.katrip.databinding.FragmentExploreBinding
import com.example.katrip.fragmentlar.explore.adapter.shaxar.ExploreAdapter
import com.example.katrip.fragmentlar.explore.shaxarIchida.main.ShaxarIchida
import com.example.log.D
import com.example.network.entity.explore.shaxarlar.javob.ShaxarlarJavob
import com.example.network.repository.kirish.ExploreRepository
import com.example.network.viewModelFactory.explore.ExploreViewModelFactory
import com.example.network.viewmodel.explore.ExploreViewModel
import retrofit2.Response


class Explore : Fragment(), ExploreAdapter.onClickListener {
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private lateinit var exploreViewModel:ExploreViewModel
    private val adapter: ExploreAdapter by lazy { ExploreAdapter(this, requireContext()) }
    private lateinit var sharedPreferences: SharedPreferences
    var til: String? =null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val view = binding.root
        setOnClickListener()
        setUi()

        return view
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences(LocalTilKey,
            AppCompatActivity.MODE_PRIVATE)!!
         til = sharedPreferences.getString("til","uz").toString()
        shaxarlarniOlish()
    }

    private fun shaxarlarniOlish() {
        if (til != null) {
            if(til =="en-us")
                til="uz"
            exploreViewModel.shaxarlar(TOKEN,"0","", til!!){
                if(it.isSuccessful){
                    shaharlar(it)
                }else{
                    D.d("Explore  exploreViewModel funi")
                }
            }
        }
    }
    private fun shaharlar(it: Response<ShaxarlarJavob>) {
            val s = it.body() as ShaxarlarJavob
            binding.apply {
                progersBar.visibility = View.GONE
                exploreShaxarlar.adapter =adapter
                exploreShaxarlar.layoutManager = GridLayoutManager(requireContext(), 3)
            }
            adapter.getData(s.data.arr)
    }

    override fun shaxarOnclick(shaxarId: Int, name: String) {
        val intent = Intent(requireContext(), ShaxarIchida::class.java)
        intent.putExtra("_id",shaxarId.toString())
        intent.putExtra("name",name)
        intent.putExtra("til",til)
        startActivity(intent)
    }
    private fun setOnClickListener() {
        qidrish()
    }

    private fun qidrish() {
        binding.qidirsh.setOnClickListener {
            startActivity(Intent(requireContext(),AsosiyQidirish::class.java))
        }
    }




}