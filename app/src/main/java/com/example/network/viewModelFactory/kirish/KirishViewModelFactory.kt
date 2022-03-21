package com.example.network.viewModelFactory.kirish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.kirish.KirishRepository
import com.example.network.viewmodel.kirish.KirishViewModel



class KirishViewModelFactory(private val loginRepository: KirishRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return KirishViewModel(loginRepository) as T
    }
}