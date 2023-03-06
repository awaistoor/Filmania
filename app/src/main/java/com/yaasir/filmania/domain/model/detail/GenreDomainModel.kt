package com.yaasir.filmania.domain.model.detail

import com.yaasir.filmania.presentation.detail.model.GenreUiModel

data class GenreDomainModel(
    val id: Int,
    val name: String
)

fun GenreDomainModel.toUiModel(): GenreUiModel {
    return GenreUiModel(id = id, name = name)
}