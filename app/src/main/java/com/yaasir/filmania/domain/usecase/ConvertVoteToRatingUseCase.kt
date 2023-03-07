package com.yaasir.filmania.domain.usecase

import javax.inject.Inject

/**
 * [ConvertVoteToRatingUseCase]
 * A use case implementation for converting vote average into rating
 * the logic here is because the vote average is with the limit of 10 we are dividing it with 2 to accommodate our 5 star rating
 * the [invoke] function take [Double] as parameter and returns [Double]
 */
class ConvertVoteToRatingUseCase @Inject constructor() {
    operator fun invoke(vote: Double): Double {
        return vote / 2
    }
}