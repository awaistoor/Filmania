package com.yaasir.filmania.domain.usecase

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.text.ParseException

@RunWith(MockitoJUnitRunner::class)
class FormatDateToYearUseCaseTest {
    private lateinit var SUT: FormatDateToYearUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        SUT = FormatDateToYearUseCase()
    }

    @Test
    fun testInvoke() {
        // region Assert
        Assert.assertEquals(SUT.invoke(getDummyDate()), getFormattedDate())
        // endregion
    }

    @Test(expected = ParseException::class)
    fun `when given wrong date format, throws exception`() {
        // region Assert
        Assert.assertEquals(SUT.invoke(getFormattedDate()), getFormattedDate())
        // endregion
    }

    private fun getFormattedDate(): String = "2023"

    private fun getDummyDate(): String = "2023-03-07"


}