package com.yaasir.filmania.domain.usecase

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class FormatDateUseCase @Inject constructor() {
    operator fun invoke(date: String): String {
        val originalDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date)
        return SimpleDateFormat("yyyy", Locale.getDefault()).format(originalDate)
    }

}