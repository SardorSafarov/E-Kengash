package com.example.network.viewmodel.takliflarLayfxaklar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.endtity.takliflarLayfxaklar.javob.TakliflarLayfxaklarJavob
import com.example.network.repository.takliflarLayfxaklar.TakliflarLayfxaklarRepisitory
import kotlinx.coroutines.launch
import retrofit2.Response

class TakliflarLayfxaklarViewModel( private val takliflarLayfxaklarRepisitory: TakliflarLayfxaklarRepisitory):
    ViewModel() {

        /*=========Takliflar va Layfxaklar olish==============*/
        fun takliflarLayfxaklar(token:String,query:String,onResponse:(response:Response<TakliflarLayfxaklarJavob>)->Unit)
        {
            viewModelScope.launch {
                try {
                    onResponse(takliflarLayfxaklarRepisitory.takliflarLayfxaklar(token,query))
                }catch (e:Exception)
                {
                    D.d("TakliflarLayfxaklarViewModel takliflarLayfxaklar funi ${e.message}")
                }
            }
        }


}