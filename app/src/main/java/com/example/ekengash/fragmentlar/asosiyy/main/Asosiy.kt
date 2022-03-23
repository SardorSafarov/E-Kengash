package com.example.ekengash.fragmentlar.asosiyy.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.ekengash.databinding.FragmentAsosiy2Binding
import com.example.asosiyQidirishOynasi.AsosiyQidirish
import com.example.ekengash.R
import com.example.ekengash.fragmentlar.asosiyy.bildirishnomalar.asosiy.Bildirshnomalar
import com.example.engYaqin.main.EngYaqin
import com.example.log.D
import com.example.qrcode.main.QRcodeScaner
import com.example.room.viewModel.UserViewModel
import com.example.servislar.ab.main.ServesAB
import com.example.servislar.aviachipta.main.ServesAvia
import com.example.servislar.avtobus.main.ServesAvtobus
import com.example.servislar.chegirmalar.mian.ServesChegirmalar
import com.example.servislar.poyezd.main.ServesPoyezd
import com.example.servislar.tanggalar.main.ServisTanggalar
import com.example.servislar.taxi.main.ServesTaxi
import com.example.servislar.turPaketlar.main.ServesTurPaket
import com.example.servislar.turarJoylar.main.ServesTurarjoy


class Asosiy : Fragment() {
    private var _binding: FragmentAsosiy2Binding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by viewModels()
    private var asosiy_rasm=1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAsosiy2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        asosiyQidirishOynasi()
        servesButton()
        asosiyBildishnomalar()
        qrcodeScaner()
        tanggalar()
        engYaqin()
        balanse()
        asosiyRasmlarUzgarishi()
    }

    private fun asosiyRasmlarUzgarishi() {
        Handler().postDelayed({
            when (asosiy_rasm){
                1->{
                    binding.constraintLayout.setBackgroundResource(R.drawable.asosiy_2)
                    asosiy_rasm=2
                }
                2->{
                    binding.constraintLayout.setBackgroundResource(R.drawable.asosiy_2)
                    asosiy_rasm=3
                }
                3->{
                    binding.constraintLayout.setBackgroundResource(R.drawable.asosiy_3)
                    asosiy_rasm=4
                }
                4->{
                    binding.constraintLayout.setBackgroundResource(R.drawable.asosiy_4)
                    asosiy_rasm=5

                }
                5->{
                    binding.constraintLayout.setBackgroundResource(R.drawable.asosiy_5)
                    asosiy_rasm=6
                }
                6->{
                    binding.constraintLayout.setBackgroundResource(R.drawable.asosiy_6)
                    asosiy_rasm=7
                }
                7->{
                    binding.constraintLayout.setBackgroundResource(R.drawable.asosiy_7)
                    asosiy_rasm=1
                }
            }
            asosiyRasmlarUzgarishi()
        },4000)

    }

    private fun balanse() {
        userViewModel.readUser.observe(requireActivity(), Observer {
            try {
                binding.foydalanuvchiBalanse.text = it.get(0).balans
            }catch (e:Exception)
            {
                D.d("Asosiy balense() da muammo")
            }

        })
    }

    private fun engYaqin() {
        binding.engYaqin.setOnClickListener {
            startActivity(Intent(requireContext(), EngYaqin::class.java))
        }
        binding.engyaqinKuproq.setOnClickListener {
            startActivity(Intent(requireContext(), EngYaqin::class.java))
        }
    }

    private fun tanggalar() {
        binding.tanggalar.setOnClickListener {
            startActivity(Intent(requireContext(),ServisTanggalar::class.java))
        }
    }

    private fun qrcodeScaner() {
        binding.qrCodeScaner.setOnClickListener {
            startActivity(Intent(requireContext(), QRcodeScaner::class.java))
        }
    }


    private fun asosiyBildishnomalar() {
        binding.asosiyBildirshnomalar.setOnClickListener {
            startActivity(Intent(requireContext(), Bildirshnomalar::class.java))
        }
    }


    /*--------------------------------------Teginma-------------------------------------------------------------*/

    private fun servesButton() {
        binding.servesAviabeletButton.setOnClickListener {
            startActivity(Intent(context, ServesAvia::class.java))
        }
        binding.servesAvtobusButton.setOnClickListener {
            startActivity(Intent(context, ServesAvtobus::class.java))
        }
        binding.servesPoyezdButton.setOnClickListener {
            startActivity(Intent(context, ServesPoyezd::class.java))
        }
        binding.servesABButton.setOnClickListener {
        startActivity(Intent(context, ServesAB::class.java))
        }
        binding.servesChegirmalarButton.setOnClickListener {
            startActivity(Intent(context, ServesChegirmalar::class.java))
        }
        binding.servesTurarJoyButton.setOnClickListener {
            startActivity(Intent(context, ServesTurarjoy::class.java))
        }
        binding.servesTaxsiButton.setOnClickListener {
            startActivity(Intent(context,ServesTaxi::class.java))
        }
        binding.servesTurpaketButton.setOnClickListener {
            startActivity(Intent(context,ServesTurPaket::class.java))
        }
    }
    private fun asosiyQidirishOynasi() {
        binding.asosiyQidirishButton.setOnClickListener {
            startActivity(Intent(context,AsosiyQidirish::class.java))
        }
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