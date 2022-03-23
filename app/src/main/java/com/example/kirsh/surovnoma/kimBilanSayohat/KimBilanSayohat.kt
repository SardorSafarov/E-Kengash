package com.example.kirsh.surovnoma.kimBilanSayohat

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.constants.Constants
import com.example.ekengash.databinding.ActivityKimBilanSayohatBinding
import com.example.ekengash.main.MainActivity
import com.example.kirsh.surovnoma.adapter.SurovNomaAdapter
import com.example.log.D
import com.example.network.endtity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import com.example.network.endtity.surovNoma.surovNomaJavob.SurovNomaJavob
import com.example.network.repository.surov.SurovNomaRepository
import com.example.network.viewModelFactory.surov.SurovNomaViewModelFactory
import com.example.network.viewmodel.surov.SurovNomaViewModel
import retrofit2.Response

class KimBilanSayohat : AppCompatActivity(),SurovNomaAdapter.onClickListener {
    private lateinit var binding: ActivityKimBilanSayohatBinding
    private lateinit var surovNomaViewModel: SurovNomaViewModel
    private val adapter: SurovNomaAdapter by lazy { SurovNomaAdapter(this, applicationContext) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKimBilanSayohatBinding.inflate(layoutInflater)
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
        surovNomaViewModel.surovNoma(Constants.TOKEN, 3) {
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
        surovNomaViewModel.surovNomaJavob(Constants.TOKEN, SurovNomaJavob(id, surveyId))
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }
}