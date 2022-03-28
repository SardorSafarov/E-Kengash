package com.example.network.viewModelFactory.taxi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.repository.taxi.TaxiRepository
import com.example.network.viewmodel.taxi.TaxiViewModel


class TaxiViewModelFactory(private val taxiRepository: TaxiRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaxiViewModel(taxiRepository) as T
    }
}