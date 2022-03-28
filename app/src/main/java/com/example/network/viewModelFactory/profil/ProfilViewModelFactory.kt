package com.example.network.viewModelFactory.kirish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.profil.ProfilRepository
import com.example.network.viewmodel.profil.ProfilViewModel


class ProfilViewModelFactory(private val profilRepository: ProfilRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfilViewModel(profilRepository) as T
    }
}