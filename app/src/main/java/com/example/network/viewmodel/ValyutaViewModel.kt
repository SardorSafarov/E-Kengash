package com.example.network.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.endtity.valyuta.ValyutaEntity
import com.example.network.repository.ValyutaRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ValyutaViewModel(private val valyutaRepository: ValyutaRepository):ViewModel() {

    /*==============Valyuta kurslari=================*/
    val valyuta:MutableLiveData<Response<ValyutaEntity>> = MutableLiveData()
    fun valyuta(){
        viewModelScope.launch {
            try {
                valyuta.value = valyutaRepository.valyuta()
            }catch (e:Exception){
                D.d("${e.message}   ValyutaViewModel valyuta funi")
            }
        }
    }

}