package com.example.katrip.fragmentlar.explore.shaxarIchida.page

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.constants.Constants
import com.example.katrip.databinding.ActivityShaxarIchidaPage1Binding
import com.example.katrip.fragmentlar.asosiyy.adapter.TakliflarLayfxaklarAdapter
import com.example.log.D
import com.example.network.entity.explore.shaxarichi.ShaxarIchidaJavob
import com.example.network.entity.takliflarLayfxaklar.javob.Arr
import com.example.network.repository.kirish.ExploreRepository
import com.example.network.repository.takliflarLayfxaklar.TakliflarLayfxaklarRepisitory
import com.example.network.viewModelFactory.explore.ExploreViewModelFactory
import com.example.network.viewModelFactory.takliflarLayfxaklar.TakliflarLayfxaklarViewModelFactory
import com.example.network.viewmodel.explore.ExploreViewModel
import com.example.network.viewmodel.takliflarLayfxaklar.TakliflarLayfxaklarViewModel
import com.example.room.viewModel.UserViewModel
import com.example.servislar.stories.TakliflarLayfxaklarFullScreen
import retrofit2.Response

class ShaxarIchidaPage1 : AppCompatActivity(), TakliflarLayfxaklarAdapter.onClickListener {
    private lateinit var binding: ActivityShaxarIchidaPage1Binding
    private lateinit var exploreViewModel: ExploreViewModel
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var takliflarLayfxaklarViewModel: TakliflarLayfxaklarViewModel
    private val takliflarLayfxaklarAdapter: TakliflarLayfxaklarAdapter by lazy {
        TakliflarLayfxaklarAdapter(this,
            applicationContext = applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityShaxarIchidaPage1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUi()
        statusBar()
        shaxarniOlish()
        layfxaklarSetUi()
        takliflarLayfxaklar()
    }

    private fun layfxaklarSetUi() {
        val takliflarLayfxaklarRepisitory = TakliflarLayfxaklarRepisitory()
        val takliflarLayfxaklarViewModelFactory =
            TakliflarLayfxaklarViewModelFactory(takliflarLayfxaklarRepisitory)
        val takliflarLayfxaklarViewModel = ViewModelProvider(
            this,
            takliflarLayfxaklarViewModelFactory
        ).get(TakliflarLayfxaklarViewModel::class.java)
        this.takliflarLayfxaklarViewModel = takliflarLayfxaklarViewModel

    }

    private fun takliflarLayfxaklar() {
        userViewModel.readUser.observe(this, Observer {
            try {
                takliflarLayfxaklarViewModel.takliflarLayfxaklar(it.get(0).token.toString(), "home")
                {
                    if (it.isSuccessful) {
                        taklifLafxaklarsetAdapterData(it.body()!!.data.arr)
                    } else {
                        D.d("Asosiy takliflarLayfxaklar funida")
                    }
                }
            } catch (e: Exception) {
                D.d("Asosiy takliflarLayfxaklar funida ${e.message}")
            }

        })

    }

    private fun taklifLafxaklarsetAdapterData(arr: List<Arr>) {
        binding.apply {
            takliflarLayfhaklarRecyc.adapter = takliflarLayfxaklarAdapter
            takliflarLayfhaklarRecyc.layoutManager = LinearLayoutManager(this@ShaxarIchidaPage1,
                LinearLayoutManager.HORIZONTAL, false)
            takliflarLayfxaklarAdapter.setData(arr)
        }

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
        exploreViewModel.shaxarlarIchida(Constants.TOKEN,
            intent.getStringExtra("_id").toString(),
            "",
            intent.getStringExtra("til").toString())
        {
            if (it.isSuccessful) {
                binding.progersBar.visibility = View.GONE
                shaxar(it)
            } else {
                D.d("ShaxarIchida shaharlar false")
            }
        }
    }

    private fun shaxar(response: Response<ShaxarIchidaJavob>) {
        val s = response.body() as ShaxarIchidaJavob
        val ss = s.data.arr[0]
        val url = ss.`360Info`
        binding.tuliqKurishBtn.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(myIntent)
        }

        binding.apply {
            Glide.with(this@ShaxarIchidaPage1).load(ss.file_link).into(image)
            name.setText(ss.name)
            locetionName.setText(ss.locetion_name)
            price.setText(ss.price.toString())
            delPrice.setText(ss.del_price.toString())
            commentCount.setText(ss.comment_count.toString())
            content.setText(ss.content.toString())
        }

    }



    override fun onClickListener(item: Arr) {
        val intent = Intent(this, TakliflarLayfxaklarFullScreen::class.java)
        intent.putExtra("text1", item.content1)
        intent.putExtra("text2", item.content2)
        intent.putExtra("text3", item.content3)
        intent.putExtra("name", item.name)
        intent.putExtra("image", item.image_link)
        startActivity(intent)
    }

    private fun statusBar() {
        window.statusBarColor = Color.WHITE
    }
}