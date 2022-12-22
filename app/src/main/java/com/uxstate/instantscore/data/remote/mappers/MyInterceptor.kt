package com.uxstate.instantscore.data.remote.mappers

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

//class implementing Interceptor for logging, retrying n modifying headers

class MyInterceptor : Interceptor {
    //throw an exception to cancel request
    @Throws(IOException::class)

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
                .newBuilder() // returns Request.Builder
                .addHeader("X-Custom-Header", "MyValue")
                .build()

        //proceed with the request
        return chain.proceed(request)
    }

}




