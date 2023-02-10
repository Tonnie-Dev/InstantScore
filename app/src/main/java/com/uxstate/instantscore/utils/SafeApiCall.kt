package com.uxstate.instantscore.utils

import java.io.IOException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber

suspend fun <T> safeFlowCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): Resource<T> {

    return withContext(dispatcher) {
        try {
            Timber.e("Inside try block: Success")
            Resource.Success(apiCall.invoke())
        } catch (exception: Exception) {

            Timber.e(exception)
            when (exception) {

                is IOException -> {
                    Timber.e("IOException occurred: $exception")

                    Resource.Error(
                        errorMessage = """
                                Could not reach the Server, please check your connection.
                        """.trimIndent()
                    )
                }

                is HttpException -> {
                    Timber.e("HttpException occurred: $exception")

                    Resource.Error(
                        errorMessage = """
                                Unexpected Error Occurred, please try again.
                        """.trimIndent()
                    )
                }

                else -> {
                    Timber.e("Other Exception occurred: $exception")

                    Resource.Error(
                        errorMessage = "Unknown Error occurred, please try again later",
                    )
                }
            }
        }
    }
}