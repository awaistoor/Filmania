package com.yaasir.filmania.domain.model.detail

import com.yaasir.filmania.presentation.detail.model.ProductionCountryUiModel

data class ProductionCountryDomainModel(
    val iso31661: String,
    val name: String
)

fun ProductionCountryDomainModel.toUiModel(): ProductionCountryUiModel {
    return ProductionCountryUiModel(iso31661 = iso31661, name = name)
}