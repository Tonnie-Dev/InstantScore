package com.uxstate.instantscore.utils

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {

    /*We attach a nullable data to the Error case as we can
     still return some data e.g. database cache*/

    class Error<T>(message: String, data: T? = null) : Resource<T>(message = message, data = data)

    /*The data is null since at loading point we don't have the data*/
    class Success<T>(data: T?) : Resource<T>(data = data)

    // it has a property which will be called from ViewModel
    class Loading<T>(val isLoading: Boolean = true) : Resource<T>()
}
