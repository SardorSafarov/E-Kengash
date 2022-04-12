package com.example.katrip.fragmentlar.kuproq.page2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapMenu.profil.main.Profil
import com.example.chapMenu.valyutaKurslari.main.ValyutaKurslari
import com.example.katrip.R
import com.example.katrip.adapter.kuproq.KuproqItem2Adapter
import com.example.katrip.databinding.FragmentKuproqitem2Binding
import com.example.katrip.recyclerViewItemEntity.KuproqItemEntitit
import com.example.engYaqin.main.EngYaqin
import com.example.qrcode.main.QRcodeScaner
import com.example.katrip.servislar.ab.main.ServesAB
import com.example.katrip.servislar.aviachipta.main.ServesAvia
import com.example.katrip.servislar.avtobus.main.ServesAvtobus
import com.example.katrip.servislar.chegirmalar.mian.ServesChegirmalar
import com.example.katrip.servislar.chiptalarim.main.ServesChiptalarim
import com.example.katrip.servislar.poyezd.main.ServesPoyezd
import com.example.katrip.servislar.saqlanganlar.main.ServesSaqlanganlar
import com.example.katrip.servislar.tanggalar.main.ServisTanggalar
import com.example.katrip.servislar.taxi.main.ServesTaxi
import com.example.katrip.servislar.turarJoylar.main.ServesTurarjoy


class Kuproqitem2 : Fragment(), KuproqItem2Adapter.OnClickLister {
    private var _binding: FragmentKuproqitem2Binding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: KuproqItem2Adapter
    private lateinit var list: List<KuproqItemEntitit>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKuproqitem2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        addDataList()
        adaptergaUlash()
    }

    private fun addDataList() {
        list = listOf(
            KuproqItemEntitit(
                icon = R.drawable.ic_chegirmalar,
                text = activity?.getString(R.string.chegirmalar).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_tanggalar,
                text = activity?.getString(R.string.tangalar).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_kamera,
                text = activity?.getString(R.string.kamera).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_chiptalarim,
                text = activity?.getString(R.string.chiptalarim).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_saqlanganlar,
                text = activity?.getString(R.string.saqlanganlar).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_eng_yaqin,
                text = activity?.getString(R.string.eng_yaqin).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_a_b,
                text = activity?.getString(R.string.a_b).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_avya,
                text = activity?.getString(R.string.aviachipta).toString()
            ),

            KuproqItemEntitit(
                icon = R.drawable.ic_poyiz,
                text = activity?.getString(R.string.poyezd).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_avtobus,
                text = activity?.getString(R.string.avtobus).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_taxi,
                text = activity?.getString(R.string.taksi).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_mehmonhonalar,
                text = activity?.getString(R.string.turar_joy).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_turpaket,
                text = activity?.getString(R.string.turpaket).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_valyuta,
                text = activity?.getString(R.string.valyuta_kursi).toString()
            ),
            KuproqItemEntitit(
                icon = R.drawable.ic_profil,
                text = activity?.getString(R.string.profil).toString()
            ),

            )
    }


    override fun onClickListener(text: String?) {
        when(text)
        {
            activity?.getString(R.string.aviachipta).toString()->{
                startActivity(Intent(context, ServesAvia::class.java))
            }
            activity?.getString(R.string.avtobus).toString()->{
                startActivity(Intent(context, ServesAvtobus::class.java))
            }
            activity?.getString(R.string.poyezd).toString()->{
                startActivity(Intent(context, ServesPoyezd::class.java))
            }
            activity?.getString(R.string.a_b).toString()->{
                startActivity(Intent(context, ServesAB::class.java))
            }
            activity?.getString(R.string.taksi).toString()->{
                startActivity(Intent(context, ServesTaxi::class.java))
            }
            activity?.getString(R.string.chegirmalar).toString()->{
                startActivity(Intent(context, ServesChegirmalar::class.java))
            }
            activity?.getString(R.string.turar_joy).toString()->{
                startActivity(Intent(context, ServesTurarjoy::class.java))
            }
            activity?.getString(R.string.valyuta_kursi).toString()->{
                startActivity(Intent(context, ValyutaKurslari::class.java))
            }
            activity?.getString(R.string.tangalar).toString()->{
                startActivity(Intent(context, ServisTanggalar::class.java))
            }
            activity?.getString(R.string.kamera).toString()->{
                startActivity(Intent(context, QRcodeScaner::class.java))
            }
            activity?.getString(R.string.chiptalarim).toString()->
            {
                startActivity(Intent(context, ServesChiptalarim::class.java))
            }
            activity?.getString(R.string.saqlanganlar).toString()->{
                startActivity(Intent(context, ServesSaqlanganlar::class.java))
            }
            activity?.getString(R.string.eng_yaqin).toString()->{
                startActivity(Intent(context, EngYaqin::class.java))
            }
            activity?.getString(R.string.profil).toString()->{
                startActivity(Intent(context, Profil::class.java))
            }
        }
    }

    private fun adaptergaUlash() {
        adapter = KuproqItem2Adapter(this)
        binding.recyclerView.adapter=adapter
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        adapter.setData(list)
    }
    /*--------------------Teginmaaa----------------*/


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}