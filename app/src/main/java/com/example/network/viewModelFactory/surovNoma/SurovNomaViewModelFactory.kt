package com.example.network.viewModelFactory.surovNoma

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.surovNoma.SurovNomaRepository
import com.example.network.viewmodel.surovNoma.SurovNomaViewModel


class SurovNomaViewModelFactory(private val loginRepository: SurovNomaRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SurovNomaViewModel(loginRepository) as T
    }
}