package com.example.network.repository.kupBeriladiganSavollar

import com.example.ekengash.kirish.RetrofitBuilder
import com.example.network.endtity.info.javob.InfoJavob
import com.example.network.endtity.kupBeriladiganSavollar.javob.KupBeriladiganSavollarJavob
import retrofit2.Response

class KupBeriladiganSavollarRepository {

    suspend fun kupBeriladiganSavollar(token:String):Response<KupBeriladiganSavollarJavob> = RetrofitBuilder().kupBeriladiganSavollar.kupBeriladiganSavollar(token)

    suspend fun info(token:String,lang:String):Response<InfoJavob> = RetrofitBuilder().kupBeriladiganSavollar.info(token,lang)


}