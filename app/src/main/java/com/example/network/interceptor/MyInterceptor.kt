package com.example.network.interceptor

import com.example.constants.Constants
import okhttp3.Interceptor


class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val requser = chain.request()
            .newBuilder()
            .addHeader("authorization", Constants.TOKEN)
            .build()
        return chain.proceed(requser)
    }
}