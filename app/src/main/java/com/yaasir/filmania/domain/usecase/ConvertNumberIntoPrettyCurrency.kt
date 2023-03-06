package com.yaasir.filmania.domain.usecase

import android.icu.text.CompactDecimalFormat
import java.util.*
import javax.inject.Inject

class ConvertNumberIntoPrettyCurrency @Inject constructor() {
    operator fun invoke(value: Int) : String =
        CompactDecimalFormat.getInstance(
            Locale.getDefault(),
            CompactDecimalFormat.CompactStyle.SHORT
        ).format(value)
}