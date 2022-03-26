package com.example.katrip.fragmentlar.kuproq.page1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chapMenu.profil.main.Profil
import com.example.chapMenu.valyutaKurslari.main.ValyutaKurslari
import com.example.katrip.R
import com.example.katrip.adapter.kuproq.KuproqItem1Adapter
import com.example.katrip.databinding.FragmentKuproqItem1Binding
import com.example.katrip.recyclerViewItemEntity.KuproqItemEntitit
import com.example.engYaqin.main.EngYaqin
import com.example.log.D
import com.example.qrcode.main.QRcodeScaner
import com.example.servislar.ab.main.ServesAB
import com.example.servislar.aviachipta.main.ServesAvia
import com.example.servislar.avtobus.main.ServesAvtobus
import com.example.servislar.chegirmalar.mian.ServesChegirmalar
import com.example.servislar.chiptalarim.main.ServesChiptalarim
import com.example.servislar.poyezd.main.ServesPoyezd
import com.example.servislar.saqlanganlar.main.ServesSaqlanganlar
import com.example.servislar.tanggalar.main.ServisTanggalar
import com.example.servislar.taxi.main.ServesTaxi
import com.example.servislar.turarJoylar.main.ServesTurarjoy


class KuproqItem1 : Fragment(), KuproqItem1Adapter.OnClickLister {
    private var _binding: FragmentKuproqItem1Binding? = null
    private val binding get() = _binding!!
    private lateinit var list: List<KuproqItemEntitit>
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
        binding.recyclerVieKuproq1.adapter=adapter
        val layoutManager = GridLayoutManager(context, 3)
        binding.recyclerVieKuproq1.layoutManager = layoutManager
        adapter.setData(list)
    }
    /*-------------Teginmaaa----------------*/


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }





}