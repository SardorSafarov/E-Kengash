package com.example.chapMenu.profil.shaxsiy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.shaxsiyMalumotlar.ShaxsiyMalumotlar
import com.example.ekengash.databinding.FragmentProfilShaxsiyBinding
import com.example.room.viewModel.UserViewModel


class ProfilShaxsiy : Fragment() {
    private var _binding: FragmentProfilShaxsiyBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilShaxsiyBinding.inflate(inflater, container, false)
        val view = binding.root
        userViewModel.readUser.observe(viewLifecycleOwner, Observer {
            binding.foydalanuvchiIsm.setText(it.get(0).full_name)
            binding.foydalanuvchiTel.setText(it.get(0).phone)
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shaxsiyProfilniTasdiqlash()

    }

    private fun shaxsiyProfilniTasdiqlash() {
        binding.shaxsiyProfilniTasdiqlash.setOnClickListener {
            startActivity(Intent(requireContext(), ShaxsiyMalumotlar::class.java))
        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}