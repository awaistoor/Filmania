package com.yaasir.filmania.domain.model.detail

import com.yaasir.filmania.presentation.detail.model.ProductionCompanyUiModel


data class ProductionCompanyDomainModel(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String
)

fun ProductionCompanyDomainModel.toUiModel(): ProductionCompanyUiModel {
    return ProductionCompanyUiModel(
        id = id,
        logoPath = logoPath,
        name = name,
        originCountry = originCountry
    )
}