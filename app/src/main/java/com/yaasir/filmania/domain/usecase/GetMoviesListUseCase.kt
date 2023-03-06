package com.yaasir.filmania.domain.usecase

import com.yaasir.filmania.domain.repository.home.HomeRepository
import javax.inject.Inject

class GetMoviesListUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    suspend operator fun invoke() = homeRepository.getTrendingMovies()
}