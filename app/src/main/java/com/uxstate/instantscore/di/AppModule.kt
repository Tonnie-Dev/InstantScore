package com.uxstate.instantscore.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uxstate.instantscore.BuildConfig
import com.uxstate.instantscore.data.local.ScoresDatabase
import com.uxstate.instantscore.data.remote.api.ScoresAPI
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.domain.usecases.*
import com.uxstate.instantscore.utils.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .collector(ChuckerCollector(context))
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        // build client
        return OkHttpClient.Builder()
            // create anonymous interceptor in the lambda and override intercept
            // passing in Interceptor.Chain parameter
            .addInterceptor { chain ->

                // return response
                chain.proceed( // create request
                    chain.request()
                        .newBuilder()
                        // add headers to the request builder
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
            } // add timeouts, logging
            .also { okHttpClient ->

                okHttpClient.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                okHttpClient.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)

                // log if in debugging phase
                if (BuildConfig.DEBUG) {
                    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {

                        level = HttpLoggingInterceptor.Level.BODY
                    }

                    okHttpClient.addInterceptor(httpLoggingInterceptor)
                }
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideScoresAPI(okHttpClient: OkHttpClient): ScoresAPI {

        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            // .baseUrl(FAKE_BASE_URL_4)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(
                MoshiConverterFactory.create(moshi)
                    .asLenient()
            )
            .client(okHttpClient)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideScoresDatabase(app: Application): ScoresDatabase {

        return Room.databaseBuilder(app, ScoresDatabase::class.java, DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideUseCaseContainer(repository: ScoresRepository): UseCaseContainer {

        return UseCaseContainer(
            getFixturesByDateUseCase = GetFixturesByDateUseCase(repository = repository),
            getFixtureDetailsUseCase = GetFixtureDetailsUseCase(repository = repository),
            getStandingsUseCase = GetStandingsUseCase(repository = repository),
            getLiveFixturesUseCase = GetLiveFixturesUseCase(repository = repository),
                getStatsUseCase = GetStatsUseCase(repository = repository)
        )
    }
}