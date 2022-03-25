package com.example.network.repository.surovNoma

import com.example.katrip.kirish.RetrofitBuilder
import com.example.network.entity.surovNoma.sayohatTurlari.response.SurovNoma1ViewJavob
import com.example.network.entity.surovNoma.surovNomaJavob.SurovNomaJavob
import retrofit2.Response


class SurovNomaRepository {

    suspend fun surovNoma(token:String,qizqish_id:Int): Response<SurovNoma1ViewJavob> = RetrofitBuilder().surovNomaApi.surovNoma(token,qizqish_id)

    suspend fun surovNomaJavob(token: String,surovNomaJavob: SurovNomaJavob) = RetrofitBuilder().surovNomaApi.surovNomaJavobi(token,surovNomaJavob)
}