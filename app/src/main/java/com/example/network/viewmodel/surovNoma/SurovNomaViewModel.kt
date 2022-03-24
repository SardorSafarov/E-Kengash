package com.example.network.viewmodel.surovNoma

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.log.D
import com.example.network.endtity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import com.example.network.endtity.surovNoma.surovNomaJavob.SurovNomaJavob
import com.example.network.repository.surovNoma.SurovNomaRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class SurovNomaViewModel(private val surovNomaRepository: SurovNomaRepository): ViewModel() {

    /*=======================SurovNoma================================*/

    fun surovNoma(token: String,qiziqsh_id:Int, onResponse: (response: Response<SurovNoma1ViewJavob>) -> Unit) {
        viewModelScope.launch {
            try {
                onResponse(surovNomaRepository.surovNoma(token,qiziqsh_id))
            } catch (e: Exception) {
                D.d("SurovNomaViewModel surovNoma funi   ${e.message} ")
            }
        }
    }

    /*=======================SurovNomaJavob========================*/
    fun surovNomaJavob(token: String,surovNomaJavob: SurovNomaJavob) {
        viewModelScope.launch {
            try {
                surovNomaRepository.surovNomaJavob(token,surovNomaJavob)
            } catch (e: Exception) {
                D.d("SurovNomaViewModel surovNomaJavob funi   ${e.message} ")
            }
        }
    }
}