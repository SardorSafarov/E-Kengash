package com.example.network.viewModelFactory.takliflarLayfxaklar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.takliflarLayfxaklar.TakliflarLayfxaklarRepisitory
import com.example.network.viewmodel.takliflarLayfxaklar.TakliflarLayfxaklarViewModel


class TakliflarLayfxaklarViewModelFactory(private val takliflarLayfxaklarRepisitory: TakliflarLayfxaklarRepisitory): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TakliflarLayfxaklarViewModel(takliflarLayfxaklarRepisitory) as T
    }
}