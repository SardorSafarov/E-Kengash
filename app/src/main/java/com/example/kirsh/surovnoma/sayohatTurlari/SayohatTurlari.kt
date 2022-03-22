package com.example.kirsh.surovnoma.sayohatTurlari

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.constants.Constants.TOKEN
import com.example.ekengash.databinding.ActivitySayohatTurlariBinding
import com.example.kirsh.surovnoma.adapter.SurovNomaAdapter
import com.example.kirsh.surovnoma.shaharlar.Shaharlar
import com.example.log.D
import com.example.network.netWorkEndtity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import com.example.network.netWorkEndtity.surovNoma.surovNomaJavob.SurovNomaJavob
import com.example.network.repository.surov.SurovNomaRepository
import com.example.network.viewModelFactory.surov.SurovNomaViewModelFactory
import com.example.network.viewmodel.surov.SurovNomaViewModel
import com.example.room.viewModel.UserViewModel
import okhttp3.Interceptor
import retrofit2.Response


class SayohatTurlari : AppCompatActivity(), SurovNomaAdapter.onClickListener {
    private lateinit var binding: ActivitySayohatTurlariBinding
    private lateinit var surovNomaViewModel: SurovNomaViewModel
    private val adapter: SurovNomaAdapter by lazy { SurovNomaAdapter(this,applicationContext) }
    private val userViewMode: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySayohatTurlariBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE
        setUi()
        sayohatTurlarniOlish()

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

    private fun sayohatTurlarniOlish() {
        userViewMode.readUser.observe(this, Observer {
            it.get(0).token?.let { it1 ->
                TOKEN = it1
                surovNomaViewModel.surovNoma(it1, 1) {
                    sayohatTurlari(it)
                }
            }
        })
    }
    private fun sayohatTurlari(it: Response<SurovNoma1ViewJavob>) {
        if (it.isSuccessful) {
                binding.progersBar.visibility = View.GONE
                val s = it.body() as SurovNoma1ViewJavob
                adapter.getData(s.data.survey)
                binding.sayohatTurlariRecyc.adapter = adapter
                binding.sayohatTurlariRecyc.layoutManager = GridLayoutManager(this, 2)
        } else {
            D.d("sayohatTurlari false")
        }
    }

    override fun surovNomaOnclick(surveyId: Int, id: Int) {
        surovNomaViewModel.surovNomaJavob(TOKEN, SurovNomaJavob(id,surveyId))
        startActivity(Intent(this,Shaharlar::class.java))
    }

}


