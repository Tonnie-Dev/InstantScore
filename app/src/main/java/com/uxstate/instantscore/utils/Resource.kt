package com.uxstate.instantscore.utils

sealed class Resource<T>(
    val data: T? = null,
    val errorMessage: String? = null
) {

    /*We attach a nullable data to the Error case as we can
     still return some data e.g. database cache*/

    class Error<T>(errorMessage: String, data: T? = null) : Resource<T>(
            errorMessage = errorMessage,
            data = data
    )

    /*The data is null since at loading point we don't have the data*/
    class Success<T>(data: T?) : Resource<T>(data = data)

    // it has a property which will be called from ViewModel
    class Loading<T>(val isLoading: Boolean = true) : Resource<T>()
}
