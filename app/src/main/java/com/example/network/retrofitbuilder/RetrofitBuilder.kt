package com.example.ekengash.kirish



import com.example.constants.Constants.URL_1
import com.example.network.api.KirshApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL_1)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val kirshApi : KirshApi by lazy {
        retrofit.create(KirshApi::class.java)
    }
}