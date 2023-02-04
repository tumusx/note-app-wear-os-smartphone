package com.github.tumusx.note_list.domain.result

sealed class ResultCommon<T>(val data: T? = null, val typeError: TypeError? = null) {
    class Success<T>(data: T) : ResultCommon<T>(data)
    class Error<T>(errorType: TypeError, data: T? = null) : ResultCommon<T>(data, errorType)
    class Loading<T>(data: T? = null) : ResultCommon<T>(data)
}