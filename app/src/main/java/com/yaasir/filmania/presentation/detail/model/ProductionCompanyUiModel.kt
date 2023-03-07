package com.yaasir.filmania.presentation.detail.model

import com.yaasir.filmania.domain.model.detail.ProductionCompanyDomainModel

/**
 * [ProductionCompanyUiModel]
 * UI model for presentation layer
 */
data class ProductionCompanyUiModel(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String
)

/**
 * [ProductionCompanyDomainModel.toUiModel]
 * Extension function to convert domain model to UI model
 * @return [ProductionCompanyUiModel]
 */
fun ProductionCompanyDomainModel.toUiModel(): ProductionCompanyUiModel {
    return ProductionCompanyUiModel(
        id = id,
        logoPath = logoPath,
        name = name,
        originCountry = originCountry
    )
}