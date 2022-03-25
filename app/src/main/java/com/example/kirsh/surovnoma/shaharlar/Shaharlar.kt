package com.example.kirsh.surovnoma.shaharlar

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.constants.Constants.TOKEN
import com.example.katrip.databinding.ActivityShaharlarBinding
import com.example.kirsh.surovnoma.adapter.SurovNomaAdapter
import com.example.kirsh.surovnoma.kimBilanSayohat.KimBilanSayohat
import com.example.log.D
import com.example.network.entity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import com.example.network.entity.surovNoma.surovNomaJavob.SurovNomaJavob
import com.example.network.repository.surovNoma.SurovNomaRepository
import com.example.network.viewModelFactory.surovNoma.SurovNomaViewModelFactory
import com.example.network.viewmodel.surovNoma.SurovNomaViewModel
import retrofit2.Response

class Shaharlar : AppCompatActivity(), SurovNomaAdapter.onClickListener {
    private lateinit var binding: ActivityShaharlarBinding
    private lateinit var surovNomaViewModel: SurovNomaViewModel
    private val adapter: SurovNomaAdapter by lazy { SurovNomaAdapter(this, applicationContext) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShaharlarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        setUi()
        shaharlarniOlish()

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

    private fun shaharlarniOlish() {
        surovNomaViewModel.surovNoma(TOKEN, 2) {
            shaharlar(it)
        }
    }

    private fun shaharlar(it: Response<SurovNoma1ViewJavob>) {
        if (it.isSuccessful) {
            binding.progersBar.visibility = View.GONE
            val s = it.body() as SurovNoma1ViewJavob
            adapter.getData(s.data.survey)
            binding.sayohatTurlariRecyc.adapter = adapter
            binding.sayohatTurlariRecyc.layoutManager = GridLayoutManager(this, 2)
        } else {
            D.d("shaharlar false")
        }
    }

    override fun surovNomaOnclick(surveyId: Int, id: Int) {
        surovNomaViewModel.surovNomaJavob(TOKEN, SurovNomaJavob(id, surveyId))
        startActivity(Intent(this, KimBilanSayohat::class.java))

    }

}