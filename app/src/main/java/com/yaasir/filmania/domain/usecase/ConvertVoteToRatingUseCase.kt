package com.yaasir.filmania.domain.usecase

import javax.inject.Inject

class ConvertVoteToRatingUseCase @Inject constructor() {
    operator fun invoke(vote: Double): Double {
        return vote / 2
    }
}