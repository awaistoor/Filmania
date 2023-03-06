package com.yaasir.filmania.domain.usecase

import com.yaasir.filmania.domain.model.detail.DetailDomainModel
import com.yaasir.filmania.domain.repository.detail.DetailRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val detailRepository: DetailRepository) {
    suspend operator fun invoke(movieId: Int): DetailDomainModel {
        return detailRepository.getMovieDetail(movieId)
    }
}