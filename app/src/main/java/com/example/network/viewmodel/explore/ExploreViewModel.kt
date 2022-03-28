package com.example.network.viewmodel.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.entity.explore.shaxarichi.ShaxarIchidaJavob
import com.example.network.entity.explore.shaxarlar.javob.ShaxarlarJavob
import com.example.network.repository.kirish.ExploreRepository
import kotlinx.coroutines.launch
import retrofit2.Response



class ExploreViewModel(private val exploreRepository: ExploreRepository): ViewModel() {

    /*=======================Shaxarlarni olish================================*/

    fun shaxarlar(token:String,query: String,id:String,til:String, onResponse: (response: Response<ShaxarlarJavob>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(exploreRepository.shaxarlar(token,query,id,til))
            }catch (e:Exception){
                D.d("ExploreViewModel shaxarlar funi   ${e.message} ")
            }
        }
    }
    fun shaxarlarIchida(token:String,query: String,id:String,til:String, onResponse: (response: Response<ShaxarIchidaJavob>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(exploreRepository.shaxarlarIchida(token,query,id,til))
            }catch (e:Exception){
                D.d("ExploreViewModel shaxarlarIchida funi   ${e.message} ")
            }
        }
    }
}