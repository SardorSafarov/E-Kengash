package com.example.network.viewModelFactory.turarJoy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.turarJoy.TurarJoyRepository
import com.example.network.viewmodel.turarJoy.TurarJoyViewModel


class TurarJoyViewModelFactory(private val turarJoyRepository: TurarJoyRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TurarJoyViewModel(turarJoyRepository) as T
    }
}