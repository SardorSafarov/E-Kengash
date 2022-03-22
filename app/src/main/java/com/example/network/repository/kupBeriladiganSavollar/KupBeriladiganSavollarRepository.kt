package com.example.network.repository.kupBeriladiganSavollar

import com.example.ekengash.kirish.RetrofitBuilder
import com.example.network.netWorkEndtity.kupBeriladiganSavollar.javob.KupBeriladiganSavollarJavob
import retrofit2.Response
import retrofit2.Retrofit

class KupBeriladiganSavollarRepository {

    suspend fun kupBeriladiganSavollar(token:String):Response<KupBeriladiganSavollarJavob> = RetrofitBuilder().kupBeriladiganSavollar.kupBeriladiganSavollar(token)
}