package com.example.ekengash.fragmentlar.asosiyy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.ekengash.R
import com.example.ekengash.databinding.FragmentAsosiy2Binding
import com.example.ekengash.entity.AsosiyServislarButtonEntity
import com.example.ekengash.entity.KuproqItemEntitit
import com.example.ekengash.fragmentlar.asosiyy.asosiy_qidirish_oynasi.AsosiyQidirish
import com.example.ekengash.servislar.ab.ServesAB
import com.example.ekengash.servislar.aviachipta.Aviachipta
import com.example.ekengash.servislar.avtobus.Avtobus
import com.example.ekengash.servislar.chegirmalar.ServesChegirmalar
import com.example.ekengash.servislar.poyezd.Poyezd
import com.example.log.D



class Asosiy : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        asosiyQidirishOynasi()
        servesButton()
    }




    /*--------------------------------------Teginma-------------------------------------------------------------*/

    private fun servesButton() {
        binding.servesAviabeletButton.setOnClickListener {
            startActivity(Intent(context,Aviachipta::class.java))
        }
        binding.servesAvtobusButton.setOnClickListener {
            startActivity(Intent(context,Avtobus::class.java))
        }
        binding.servesPoyezdButton.setOnClickListener {
            startActivity(Intent(context,Poyezd::class.java))
        }
        binding.servesABButton.setOnClickListener {
        startActivity(Intent(context,ServesAB::class.java))
        }
        binding.servesChegirmalarButton.setOnClickListener {
            startActivity(Intent(context,ServesChegirmalar::class.java))
        }
    }
    private fun asosiyQidirishOynasi() {
        binding.asosiyQidirishButton.setOnClickListener {
            startActivity(Intent(context,AsosiyQidirish::class.java))
        }
    }
    private var _binding: FragmentAsosiy2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAsosiy2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    //    private val list:List<AsosiyServislarButtonEntity> = listOf(
//        AsosiyServislarButtonEntity(
//            buttonName = listOf(
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_a_b,
//                    text = "A_B"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_avya,
//                    text = "Aviabelet"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_poyiz,
//                    text = "Poyezd"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_mehmonhonalar,
//                    text = "Turar-joy"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_avtobus,
//                    text = "Avtobus"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_taxi,
//                    text = "Taksi"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_turpaket,
//                    text = "Turpaket"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_chegirmalar,
//                    text = "Chegirmalar"
//                )
//            )
//        ),
//        AsosiyServislarButtonEntity(
//            buttonName = listOf(
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_tanggalar,
//                    text = "Tangalar"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_kamera,
//                    text = "Kamera"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_chiptalarim,
//                    text = "Chiptalarim"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_sayohatlarim,
//                    text = "Sayohatlarim"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_saqlanganlar,
//                    text = "Saqlanganlar"
//                ),
//                KuproqItemEntitit(
//                    icon = R.drawable.ic_mudatliy_tolov,
//                    text = "Muddatli to`lov"
//                )
//            )
//        )
//
//    )
}