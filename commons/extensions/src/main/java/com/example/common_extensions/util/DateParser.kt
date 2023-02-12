package com.example.common_extensions.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

enum class DatePattern(val pattern: String) {
    DATE_MONTH_YEAR(pattern = "dd/MM/yyyy"),
    MONTH_YEAR(pattern = "MM/yyyy"),
    DAY_MONTH(pattern = "dd/MM")
}

fun String.getDateActual(patternDate: String): String? {
    val simpleDateFormat = SimpleDateFormat(patternDate, Locale.getDefault())
    val dateActual = Date()
    return try {
        simpleDateFormat.format(dateActual)
    } catch (exception: IllegalArgumentException) {
        exception.printStackTrace()
        null
    } catch (exception: ParseException) {
        exception.printStackTrace()
        null
    }
}