package com.example.network.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.endtity.KirishEntiyt1
import com.example.network.endtity.kirish.KirishEntity
import com.example.network.repository.KirishRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class KirishViewModel(private val kirishRepository: KirishRepository):ViewModel() {

    val telJunatish: MutableLiveData<Response<KirishEntiyt1>> = MutableLiveData()

    fun telJunatish(tel:String)
    {
        viewModelScope.launch {
            try {
                telJunatish.value = kirishRepository.telJunatish(tel)
            }catch (e:Exception)
            {
                D.d("${e.message}   KirishViewModel telJunatish funi")
            }
        }
    }
}