package com.yaasir.filmania.domain.usecase

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * [FormatDateToYearUseCase]
 * A use case implementation for converting a yyyy-MM-dd formatted date into yyyy format
 * the [invoke] function takes [String] as date parameter
 */
class FormatDateToYearUseCase @Inject constructor() {
    operator fun invoke(date: String): String {
        val originalDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date)
        return SimpleDateFormat("yyyy", Locale.getDefault()).format(originalDate)
    }

}