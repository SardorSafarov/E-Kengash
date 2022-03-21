package com.example.network.viewModelFactory.surov

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.kirish.KirishRepository
import com.example.network.repository.surov.SurovNomaRepository
import com.example.network.viewmodel.kirish.KirishViewModel
import com.example.network.viewmodel.surov.SurovNomaViewModel


class SurovNomaViewModelFactory(private val loginRepository: SurovNomaRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SurovNomaViewModel(loginRepository) as T
    }
}