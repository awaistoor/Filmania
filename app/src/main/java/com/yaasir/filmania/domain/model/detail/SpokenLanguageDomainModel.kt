package com.yaasir.filmania.domain.model.detail

import com.yaasir.filmania.presentation.detail.model.SpokenLanguageUiModel

data class SpokenLanguageDomainModel(
    val englishName: String,
    val iso6391: String,
    val name: String
)

fun SpokenLanguageDomainModel.toUiModel(): SpokenLanguageUiModel {
    return SpokenLanguageUiModel(englishName = englishName, iso6391 = iso6391, name = name)
}