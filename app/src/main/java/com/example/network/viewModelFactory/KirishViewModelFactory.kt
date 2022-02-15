package com.example.network.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.KirishRepository
import com.example.network.viewmodel.KirishViewModel



class KirishViewModelFactory(private val loginRepository: KirishRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return KirishViewModel(loginRepository) as T
    }
}