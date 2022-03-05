package com.example.network.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.ValyutaRepository
import com.example.network.viewmodel.ValyutaViewModel


class ValyutaViewModelFactory(private val valyutaRepository: ValyutaRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ValyutaViewModel(valyutaRepository) as T
    }
}