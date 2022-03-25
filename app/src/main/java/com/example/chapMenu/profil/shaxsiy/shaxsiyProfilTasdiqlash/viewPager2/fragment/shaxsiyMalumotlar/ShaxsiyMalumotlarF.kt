package com.example.chapMenu.profil.shaxsiy.shaxsiyProfilTasdiqlash.viewPager2.fragment.shaxsiyMalumotlar

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.constants.Constants
import com.example.katrip.R
import com.example.katrip.databinding.FragmentShaxsiyMalumotlarBinding
import com.example.log.D
import com.example.network.entity.profil.shaxsniTasdiqlash.shaxsiy.ShaxsiyMalumotlarSurov
import com.example.network.repository.profil.ProfilRepository
import com.example.network.viewModelFactory.kirish.ProfilViewModelFactory
import com.example.network.viewmodel.profil.ProfilViewModel

class ShaxsiyMalumotlarF : Fragment() {
    private var _binding: FragmentShaxsiyMalumotlarBinding? = null
    private val binding get() = _binding!!
    private lateinit var profilViewModel: ProfilViewModel
    private val validatsitaMessage="to'ldirilishi shart"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShaxsiyMalumotlarBinding.inflate(inflater, container, false)
        val view = binding.root
        setOnClickListener()
        statusBar()
        return view
    }
    private fun statusBar() {
        activity?.window?.statusBarColor = Color.parseColor("#F3F3F3")
    }
    private fun setOnClickListener() {
        setUi()
        davomEtish()
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
    private fun davomEtish() {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Xatolik!!")
        alertDialog.setMessage("Iltimos, sahifadagi barcha maydonlarni to'ldiring!")
        alertDialog.setPositiveButton("Tushundim"){ dialogInterface: DialogInterface, i: Int -> }
        binding.davomEtishButton.setOnClickListener {
            if(validatsiyaEditText()){
                shaxsiyMalumotQushish()

            }else
            {
                alertDialog.show()
            }

        }
    }

    private fun shaxsiyMalumotQushish() {
        profilViewModel.profilMalumotlarQushish(Constants.TOKEN, ShaxsiyMalumotlarSurov(
            fname = binding.foydalanuvchiIsmi.text.toString(),
            lname = binding.foydalanuvchiFamil.text.toString(),
            dname = binding.foydalanuvchiOtasi.text.toString(),
            bdate = binding.foydalanuvchiTugulganKuni.text.toString(),
            text_address = binding.foydalanuvchiViloyat.text.toString(),
            region = binding.foydalanuvchiViloyat.text.toString(),
            gender = if(binding.erkak.isChecked) 1 else 0,
            email = binding.foydalanuvchiEmail.text.toString(),
            country = binding.foydalanuvchiDavlat.text.toString(),
            next_phone = binding.foydalanuvchiTel.text.toString()
        )
        )
        {
            if(it.isSuccessful){
                if(it.body()!!.status == "success"){
                    D.d("sardor   ${it.body()}")
                    findNavController().navigate(R.id.action_shaxsiyMalumotlarF_to_passporMalumotlarF)
                }
                    Toast.makeText(requireContext(), "Ma'lumolar qo'shildi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validatsiyaEditText(): Boolean {
        binding.apply {
            if(foydalanuvchiIsmi.text?.length==0)
            {
                ismEditText1.error = "Ismini $validatsitaMessage"
                return false
            }
            if(foydalanuvchiFamil.text?.length==0)
            {
                familEditText1.error = "Familiyasini $validatsitaMessage"
                return false
            }
            if(foydalanuvchiOtasi.text?.length==0)
            {
                otasiEditText1.error = "Otasini $validatsitaMessage"
                return false
            }
            if(foydalanuvchiTugulganKuni.text?.length==0)
            {
                tugulganKunEditText1.error = "Tug'ulgan kunni $validatsitaMessage"
                return false
            }
            if(foydalanuvchiDavlat.text?.length==0)
            {
                davlatEditText1.error = "Davlatni $validatsitaMessage"
                return false
            }
            if(foydalanuvchiViloyat.text?.length==0)
            {
                viloyatEditText1.error = "Viloyatni $validatsitaMessage"
                return false
            }
            if(foydalanuvchiTel.text?.length==0)
            {
                telefonEditText1.error = "Telefonnii $validatsitaMessage"
                return false
            }
            if(foydalanuvchiEmail.text?.length==0)
            {
                emailEditText1.error = "Emailni $validatsitaMessage"
                return false
            }


        }
        return true
    }


    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            activity?.finish()
        }
    }



}