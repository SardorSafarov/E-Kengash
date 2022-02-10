package com.example.ekengash.fragmentlar.kuproq

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ekengash.R
import com.example.ekengash.adapter.kuproq.KuproqItem1Adapter
import com.example.ekengash.databinding.FragmentKuproqBinding
import com.example.ekengash.databinding.FragmentKuproqItem1Binding
import com.example.ekengash.entity.KuproqItemEntitit
import com.example.ekengash.servislar.Aviachipta
import com.example.ekengash.servislar.Avtobus
import com.example.ekengash.servislar.Poyezd


class KuproqItem1 : Fragment(), KuproqItem1Adapter.OnClickLister {


    private lateinit var adapter: KuproqItem1Adapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = KuproqItem1Adapter(this)
        adaptergaUlash()
    }

    private fun adaptergaUlash() {
        binding.recyclerVieKuproq1.adapter=adapter
        val layoutManager = GridLayoutManager(context, 3)
        binding.recyclerVieKuproq1.layoutManager = layoutManager
        adapter.setData(list)
    }
    override fun onClickListener(text: String) {
        when(text)
        {
            "Aviachipta"->{
                startActivity(Intent(context,Aviachipta::class.java))
            }
            "Avtobus"->{
                startActivity(Intent(context,Avtobus::class.java))
            }
            "Poyezd"->{
                startActivity(Intent(context,Poyezd::class.java))
            }
            else->{

            }
        }
    }

    /*-------------Teginmaaa----------------*/
    private var _binding: FragmentKuproqItem1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKuproqItem1Binding.inflate(inflater, container, false)
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