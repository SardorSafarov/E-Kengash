package com.example.network.repository

import com.example.ekengash.kirish.RetrofitBuilder
import com.example.network.endtity.KirishEntiyt1
import com.example.network.endtity.kirish.KirishEntity
import retrofit2.Response

class KirishRepository {

    suspend fun telJunatish(tel:String):Response<KirishEntiyt1>{
        return RetrofitBuilder().kirshApi.telJunatish(tel)
    }
}