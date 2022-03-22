package com.example.network.viewModelFactory.kupBeriladiganSavollar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.kirish.KirishRepository
import com.example.network.repository.kupBeriladiganSavollar.KupBeriladiganSavollarRepository
import com.example.network.viewmodel.kirish.KirishViewModel
import com.example.network.viewmodel.kupBeriladiganSavollar.KupBeriladiganSavollarViewModel


class KupBeriladiganSavollarViewModelFactory(private val kupBeriladiganSavollarRepository: KupBeriladiganSavollarRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return KupBeriladiganSavollarViewModel(kupBeriladiganSavollarRepository) as T
    }
}