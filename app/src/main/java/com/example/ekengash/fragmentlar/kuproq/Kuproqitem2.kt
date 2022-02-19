package com.example.ekengash.fragmentlar.kuproq

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ekengash.R
import com.example.ekengash.adapter.kuproq.KuproqItem2Adapter
import com.example.ekengash.databinding.FragmentKuproqitem2Binding
import com.example.ekengash.entity.KuproqItemEntitit
import com.example.ekengash.servislar.aviachipta.ServesAvia
import com.example.ekengash.servislar.avtobus.main.ServesAvtobus
import com.example.ekengash.servislar.poyezd.ServesPoyezd


class Kuproqitem2 : Fragment(), KuproqItem2Adapter.OnClickLister {

    private lateinit var adapter: KuproqItem2Adapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = KuproqItem2Adapter(this)
        adaptergaUlash()
    }

    private fun adaptergaUlash() {
        binding.recyclerView.adapter=adapter
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        adapter.setData(list)
    }
    override fun onClickListener(text: String) {
        when(text)
        {
            "Aviachipta"->{
                startActivity(Intent(context, ServesAvia::class.java))
            }
            "Avtobus"->{
                startActivity(Intent(context, ServesAvtobus::class.java))
            }
            "Poyezd"->{
                startActivity(Intent(context, ServesPoyezd::class.java))
            }
            else->{

            }
        }
    }


    /*--------------------Teginmaaa----------------*/
    private var _binding: FragmentKuproqitem2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKuproqitem2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private var list: List<KuproqItemEntitit> = listOf(
        KuproqItemEntitit(
            icon = R.drawable.ic_chegirmalar,
            text = "Chegirmalar"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_tanggalar,
            text = "Tanggalar"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_kamera,
            text = "Kamera"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_chiptalarim,
            text = "Chiptalarim"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_sayohatlarim,
            text = "Sayohatlarim"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_saqlanganlar,
            text = "Saqlanganlar"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_mudatliy_tolov,
            text = "Muddatli to'lov"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_a_b,
            text = "A-B"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_avya,
            text = "Aviachipta"
        ),

        KuproqItemEntitit(
            icon = R.drawable.ic_poyiz,
            text = "Poyezd"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_avtobus,
            text = "Avtobus"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_taxi,
            text = "Taksi"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_mehmonhonalar,
            text = "Mehmonxona"
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_turpaket,
            text = "Turpaket"
        )

    )


}