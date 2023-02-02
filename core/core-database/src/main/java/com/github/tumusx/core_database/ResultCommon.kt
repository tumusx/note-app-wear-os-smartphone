package com.github.tumusx.core_database

sealed class ResultCommon<T>(val success: T? = null, val error: String? = null) {
    class Success<T>(data: T) : ResultCommon<T>(data)
    class Error<T>(errorType: String) : ResultCommon<T>(error = errorType)
    object Loading : ResultCommon<Nothing>()
}