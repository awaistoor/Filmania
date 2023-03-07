package com.yaasir.filmania.domain.usecase

import android.icu.text.CompactDecimalFormat
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class ConvertNumberIntoPrettyCurrencyTest {
    private lateinit var SUT: ConvertNumberIntoPrettyCurrency

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        SUT = ConvertNumberIntoPrettyCurrency()
    }

    @Test
    fun `when given int, return string value`() {
        // region Arrange
        Mockito.`when`(CompactDecimalFormat.getInstance()).thenReturn(CompactDecimalFormat.getInstance())
        // endregion

        // region Assert
        Assert.assertTrue(SUT.invoke(getDummyIntValue()) is String)
        // endregion
    }

    private fun getDummyIntValue(): Int = 100000
}