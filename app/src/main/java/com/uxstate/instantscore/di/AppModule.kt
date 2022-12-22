package com.uxstate.instantscore.di


import com.uxstate.instantscore.BuildConfig
import com.uxstate.instantscore.utils.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {



    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        //build client
        return OkHttpClient.Builder()

                //create anonymous interceptor in the lambda and override intercept
                // passing in Interceptor.Chain parameter
                .addInterceptor { chain ->

                    //return response
                    chain.proceed( //create request
                            chain.request()
                                    .newBuilder()

                                    //add headers to the request builder
                                    .also {
                                        it.addHeader(
                                                name = X_RAPID_KEY,
                                                value = API_KEY
                                        )
                                        it.addHeader(
                                                name = X_RAPID_HOST,
                                                value = HOST_VALUE
                                        )
                                    }
                                    .build()

                    )
                } //add timeouts, logging
                .also { okHttpClient ->

                    okHttpClient.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    okHttpClient.readTimeout(
                            READ_TIMEOUT,
                            TimeUnit.SECONDS
                    ) //log if in debugging phase
                    if (BuildConfig.DEBUG) {
                        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {

                            level = HttpLoggingInterceptor.Level.BODY
                        }

                        okHttpClient.addInterceptor(httpLoggingInterceptor)
                    }
                }
                .build()


    }


}