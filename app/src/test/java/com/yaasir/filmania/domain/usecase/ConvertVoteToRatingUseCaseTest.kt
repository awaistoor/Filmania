package com.yaasir.filmania.domain.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ConvertVoteToRatingUseCaseTest {

    private lateinit var SUT: ConvertVoteToRatingUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        SUT = ConvertVoteToRatingUseCase()
    }

    @Test
    fun testInvoke() {
        Assert.assertEquals(2.0, SUT.invoke(4.0), 0.0)
    }

    @Test
    fun `when invoke, confirm that the return value is double`() {
        Assert.assertTrue(SUT.invoke(4.0) is Double)
    }
}