package com.yaasir.filmania.domain.usecase

import android.icu.text.CompactDecimalFormat
import java.util.*
import javax.inject.Inject

/**
 * [ConvertNumberIntoPrettyCurrency]
 * A use case implementation for converting long integer values into [CompactDecimalFormat]
 * for example: 1000 will become 1K
 * the [invoke] function take [Int] as parameter and returns formatted [String]
 */
class ConvertNumberIntoPrettyCurrency @Inject constructor() {
    operator fun invoke(value: Int) : String =
        CompactDecimalFormat.getInstance(
            Locale.getDefault(),
            CompactDecimalFormat.CompactStyle.SHORT
        ).format(value)
}