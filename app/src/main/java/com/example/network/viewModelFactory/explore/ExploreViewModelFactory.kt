package com.example.network.viewModelFactory.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.kirish.ExploreRepository
import com.example.network.viewmodel.explore.ExploreViewModel


class ExploreViewModelFactory(private val loginRepository: ExploreRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExploreViewModel(loginRepository) as T
    }
}