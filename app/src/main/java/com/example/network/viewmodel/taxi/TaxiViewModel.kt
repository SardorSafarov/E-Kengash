package com.example.network.viewmodel.taxi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.entity.taxi.shaxarQidirsh.Javob.TaxsiShaxarQidirishJavob
import com.example.network.repository.taxi.TaxiRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class TaxiViewModel(private val taxiRepository: TaxiRepository) :ViewModel() {


    /*==============Hududlarni qidirish==============*/
    fun taxiManzilQidirish(
        input: String,
        inputtype: String,
        key: String,onResponse:(response:Response<TaxsiShaxarQidirishJavob>)->Unit
    ){
        viewModelScope.launch {
            try {
                onResponse(taxiRepository.taxiManzilQidirish(input,inputtype,key))
            }catch (e:Exception)
            {
                D.d("TaxiViewModel  taxiManzilQidirish funi  ${e.message}")
            }
        }
    }
}