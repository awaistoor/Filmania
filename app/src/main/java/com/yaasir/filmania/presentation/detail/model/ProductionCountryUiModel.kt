package com.yaasir.filmania.presentation.detail.model

import com.yaasir.filmania.domain.model.detail.ProductionCountryDomainModel

/**
 * [ProductionCountryUiModel]
 * UI model for presentation layer
 */
data class ProductionCountryUiModel(
    val iso31661: String,
    val name: String
)

/**
 * [ProductionCountryDomainModel.toUiModel]
 * Extension function to convert domain model to UI model
 * @return [ProductionCountryUiModel]
 */
fun ProductionCountryDomainModel.toUiModel(): ProductionCountryUiModel {
    return ProductionCountryUiModel(iso31661 = iso31661, name = name)
}