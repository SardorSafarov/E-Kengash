package com.example.network.viewmodel.kupBeriladiganSavollar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.endtity.info.javob.InfoJavob
import com.example.network.endtity.kupBeriladiganSavollar.javob.KupBeriladiganSavollarJavob
import com.example.network.repository.kupBeriladiganSavollar.KupBeriladiganSavollarRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class KupBeriladiganSavollarViewModel(private val kupBeriladiganSavollarRepository: KupBeriladiganSavollarRepository):ViewModel() {


    fun KupBeriladiganSavollarViewModel(token:String,onResponse:(response:Response<KupBeriladiganSavollarJavob>)->Unit)
    {
        viewModelScope.launch {
            try {
                    onResponse(kupBeriladiganSavollarRepository.kupBeriladiganSavollar(token))

            }catch (e:Exception)
            {
                D.d("KupBeriladiganSavollarViewModel  KupBeriladiganSavollarViewModel funi ${e.message}")
            }
        }

    }

    fun info(token:String,lang:String,onResponse:(response:Response<InfoJavob>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(kupBeriladiganSavollarRepository.info(token,lang))

            }catch (e:Exception)
            {
                D.d("KupBeriladiganSavollarViewModel  info funi ${e.message}")
            }
        }

    }

}