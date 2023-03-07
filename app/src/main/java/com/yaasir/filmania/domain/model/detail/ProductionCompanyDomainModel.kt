package com.yaasir.filmania.domain.model.detail


/**
 * [ProductionCompanyDomainModel]
 * Production company model for domain layer
 */
data class ProductionCompanyDomainModel(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String
)