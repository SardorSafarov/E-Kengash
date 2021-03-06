package com.example.network.repository.kupBeriladiganSavollar

import com.example.katrip.kirish.RetrofitBuilder
import com.example.network.entity.bildirshnoma.BildirishNomaJavob
import com.example.network.entity.info.javob.InfoJavob
import com.example.network.entity.kupBeriladiganSavollar.javob.KupBeriladiganSavollarJavob
import retrofit2.Response

class KupBeriladiganSavollarRepository {

    suspend fun kupBeriladiganSavollar(token:String):Response<KupBeriladiganSavollarJavob> = RetrofitBuilder().kupBeriladiganSavollar.kupBeriladiganSavollar(token)

    suspend fun info(token:String,lang:String):Response<InfoJavob> = RetrofitBuilder().kupBeriladiganSavollar.info(token,lang)

    suspend fun bildirishnoma(token:String):Response<BildirishNomaJavob> = RetrofitBuilder().kupBeriladiganSavollar.bildirishnoma(token)

}