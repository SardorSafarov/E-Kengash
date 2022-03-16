package com.example.ekengash.fragmentlar.kuproq.page1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chapMenu.valyutaKurslari.ValyutaKurslari
import com.example.ekengash.R
import com.example.ekengash.adapter.kuproq.KuproqItem1Adapter
import com.example.ekengash.databinding.FragmentKuproqItem1Binding
import com.example.ekengash.recyclerViewItemEntity.KuproqItemEntitit
import com.example.qrcode.main.QRcodeScaner
import com.example.servislar.ab.main.ServesAB
import com.example.servislar.aviachipta.main.ServesAvia
import com.example.servislar.avtobus.main.ServesAvtobus
import com.example.servislar.chegirmalar.ServesChegirmalar
import com.example.servislar.chiptalarim.ServesChiptalarim
import com.example.servislar.poyezd.main.ServesPoyezd
import com.example.servislar.saqlanganlar.main.ServesSaqlanganlar
import com.example.servislar.tanggalar.main.ServisTanggalar
import com.example.servislar.taxi.main.ServesTaxi
import com.example.servislar.turarJoylar.main.ServesTurarjoy


class KuproqItem1 : Fragment(), KuproqItem1Adapter.OnClickLister {
    private var _binding: FragmentKuproqItem1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKuproqItem1Binding.inflate(inflater, container, false)
        adapter = KuproqItem1Adapter(this)
        return binding.root
    }


    private lateinit var adapter: KuproqItem1Adapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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
                startActivity(Intent(context, ServesAvia::class.java))
            }
            "Avtobus"->{
                startActivity(Intent(context, ServesAvtobus::class.java))
            }
            "Poyezd"->{
                startActivity(Intent(context, ServesPoyezd::class.java))
            }
            "A-B"->{
                startActivity(Intent(context, ServesAB::class.java))
            }
            "Taksi"->{
                startActivity(Intent(context, ServesTaxi::class.java))
            }
            "Chegirmalar"->{
                startActivity(Intent(context, ServesChegirmalar::class.java))
            }
            "Mehmonxona"->{
                startActivity(Intent(context, ServesTurarjoy::class.java))
            }
            "Valyuta kursi"->{
                startActivity(Intent(context, ValyutaKurslari::class.java))
            }
            "Tanggalar"->{
                startActivity(Intent(context, ServisTanggalar::class.java))
            }
            "Kamera"->{
                startActivity(Intent(context, QRcodeScaner::class.java))
            }
            "Chiptalarim"->
            {
                startActivity(Intent(context, ServesChiptalarim::class.java))
            }
            "Saqlanganlar"->{
                startActivity(Intent(context, ServesSaqlanganlar::class.java))
            }
        }
    }

    /*-------------Teginmaaa----------------*/


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
//        KuproqItemEntitit(
//            icon = R.drawable.ic_sayohatlarim,
//            text = "Sayohatlarim"
//        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_saqlanganlar,
            text = "Saqlanganlar"
        ),
//        KuproqItemEntitit(
//            icon = R.drawable.ic_mudatliy_tolov,
//            text = "Muddatli to'lov"
//        ),
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
        ),
        KuproqItemEntitit(
            icon = R.drawable.ic_valyuta,
            text = "Valyuta kursi"
        )

    )


}