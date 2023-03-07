package com.yaasir.filmania.presentation.detail.model

import com.yaasir.filmania.domain.model.detail.SpokenLanguageDomainModel

/**
 * [SpokenLanguageUiModel]
 * UI model for presentation layer
 */
data class SpokenLanguageUiModel(
    val englishName: String,
    val iso6391: String,
    val name: String
)

/**
 * [SpokenLanguageDomainModel.toUiModel]
 * Extension function to convert domain model to UI model
 * @return [SpokenLanguageUiModel]
 */
fun SpokenLanguageDomainModel.toUiModel(): SpokenLanguageUiModel {
    return SpokenLanguageUiModel(englishName = englishName, iso6391 = iso6391, name = name)
}