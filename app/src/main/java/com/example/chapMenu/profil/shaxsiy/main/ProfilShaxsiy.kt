package com.example.chapMenu.profil.shaxsiy.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chapMenu.profil.shaxsiy.shaxsiyProfilTasdiqlash.viewPager2.main.ShaxsiyProfilniTasdiqlash
import com.example.constants.Constants
import com.example.katrip.databinding.FragmentProfilShaxsiyBinding
import com.example.log.D
import com.example.network.entity.profil.user.UserData
import com.example.network.entity.profil.user.UserPassport
import com.example.network.repository.profil.ProfilRepository
import com.example.network.viewModelFactory.kirish.ProfilViewModelFactory
import com.example.network.viewmodel.profil.ProfilViewModel
import com.example.room.viewModel.UserViewModel


class ProfilShaxsiy : Fragment() {
    private var _binding: FragmentProfilShaxsiyBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var profilViewModel: ProfilViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentProfilShaxsiyBinding.inflate(inflater, container, false)
        val view = binding.root
        setOnClickListener()
        instalizatsiya()
        return view
    }

    override fun onResume() {
        super.onResume()
        foydalanuvchiniTekshirish()
    }

    private fun instalizatsiya() {
        setUi()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        room()
        foydalanuvchiniTekshirish()
    }

    private fun room() {
        userViewModel.readUser.observe(viewLifecycleOwner, Observer {
            binding.foydalanuvchiIsm.setText(it.get(0).full_name)
            binding.foydalanuvchiTel.setText(it.get(0).phone)
        })
    }

    private fun setOnClickListener() {
        shaxsiyProfilniTasdiqlash()
    }

    private fun setUi() {
        val profilRepository = ProfilRepository()
        val profilViewModelFactory =
            ProfilViewModelFactory(profilRepository)
        val profilViewModel = ViewModelProvider(
            this,
            profilViewModelFactory
        ).get(ProfilViewModel::class.java)
        this.profilViewModel = profilViewModel
    }

    fun foydalanuvchiniTekshirish() {
        profilViewModel.userHaqida(Constants.TOKEN) {
            if (it.isSuccessful) {
                binding.progress.visibility = View.GONE
                if (it.body()!!.data.userData.lname != null) {
                    userData(it.body()!!.data.userData, it.body()!!.data.userPassport)
                    D.d(it.body()!!.data.userPassport.toString())
                    binding.userTasdiqlanmagan.visibility = View.GONE
                    binding.userTasdiqlangan.visibility = View.VISIBLE
                } else {
                    binding.userTasdiqlanmagan.visibility = View.VISIBLE
                    binding.userTasdiqlangan.visibility = View.GONE
                }
            }
        }
    }

    private fun userData(userData: UserData, userPassport: UserPassport) {
        binding.apply {
            userId.setText(userData.id?.toString())
            userFio.setText(userData.lname?.toString() + " " + userData.fname?.toString() + " " + userData.dname?.toString())
            userTel.setText(userData.next_phone?.toString())
            userTugKuni.setText(userData.bdate?.toString())
            userJinsi.setText(userData.gender?.toString())
            userPasssport.setText(userPassport.number?.toString())
            val gender = when (userData.gender) {
                "1.0" -> {
                    "Erkak"
                }
                else -> {
                    "Ayol"
                }
            }
            userJshshir.setText(gender)
            userDavlat.setText(userData.country?.toString())
            userYashash.setText(userData.text_address?.toString())
            userEmail.setText(userData.email?.toString())

        }
    }

    private fun shaxsiyProfilniTasdiqlash() {
        binding.shaxsiyProfilniTasdiqlash.setOnClickListener {
            startActivity(Intent(requireContext(), ShaxsiyProfilniTasdiqlash::class.java))
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}