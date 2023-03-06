package com.yaasir.filmania.domain.model.detail

data class ProductionCompanyDomainModel(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String
)