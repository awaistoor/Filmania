package com.yaasir.filmania.presentation.detail.model

import com.yaasir.filmania.domain.model.detail.GenreDomainModel

/**
 * [GenreUiModel]
 * UI model for presentation layer
 */
data class GenreUiModel(
    val id: Int,
    val name: String
)

/**
 * [GenreDomainModel.toUiModel]
 * Extension function to convert domain model to UI model
 * @return [GenreUiModel]
 */
fun GenreDomainModel.toUiModel(): GenreUiModel {
    return GenreUiModel(id = id, name = name)
}