package com.example.ekengash.kirish



import com.example.constants.Constants.URL_1
import com.example.constants.Constants.URL_VALYUTA
import com.example.kirsh.surovnoma.sayohatTurlari.MyInterceptor

import com.example.network.api.KirshApi
import com.example.network.api.SurovNomaApi
import com.example.network.api.ValyutaApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL_1)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val kirshApi: KirshApi by lazy {
        retrofit.create(KirshApi::class.java)
    }

    val surovNomaApi: SurovNomaApi by lazy {
        retrofit.create(SurovNomaApi::class.java)
    }

    private val valyutaretrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL_VALYUTA)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val valyutaApi: ValyutaApi by lazy {
        valyutaretrofit.create(ValyutaApi::class.java)
    }
}