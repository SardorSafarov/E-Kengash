package com.example.network.viewmodel.turarJoy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.entity.taxi.shaxarQidirsh.Javob.TaxsiShaxarQidirishJavob
import com.example.network.entity.turarJoy.izlash.TurarJoyIzlashJavob
import com.example.network.entity.turarJoy.xona.javob.TurarJoyXonaHaqida
import com.example.network.repository.turarJoy.TurarJoyRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class TurarJoyViewModel(private val turarJoyRepository: TurarJoyRepository):ViewModel() {

    /*==============Hududlarni qidirish==============*/
    fun taxiManzilQidirish(
        token: String,
        people: String,
        child: String,
        city: String,
        lang_code: String,
        onResponse:(response: Response<TurarJoyIzlashJavob>)->Unit
    ){
        viewModelScope.launch {
            try {
                onResponse(turarJoyRepository.turarJoyIzlash(token, people, child, city, lang_code))
            }catch (e:Exception)
            {
                D.d("TaxiViewModel  taxiManzilQidirish funi  ${e.message}")
            }
        }
    }

    /*==============Hududlarni qidirish==============*/
    fun turarJoyXona(
        token: String,
        id: String,
        lang_code: String,
        onResponse:(response: Response<TurarJoyXonaHaqida>)->Unit
    ){
        viewModelScope.launch {
            try {
                onResponse(turarJoyRepository.turarJoyXona(token,id,lang_code))
            }catch (e:Exception)
            {
                D.d("TaxiViewModel  taxiManzilQidirish funi  ${e.message}")
            }
        }
    }
}