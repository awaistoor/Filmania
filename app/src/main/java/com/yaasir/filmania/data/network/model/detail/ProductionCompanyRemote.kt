package com.yaasir.filmania.data.network.model.detail


import com.google.gson.annotations.SerializedName
import com.yaasir.filmania.domain.model.detail.ProductionCompanyDomainModel

/**
 * [ProductionCompanyRemote]
 * Remote model for network layer
 */
data class ProductionCompanyRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
)

/**
 * [ProductionCompanyRemote.toDomainModel]
 * Extension function to convert remote model to domain model
 * @return [ProductionCompanyDomainModel]
 */
fun ProductionCompanyRemote.toDomainModel(): ProductionCompanyDomainModel {
    return ProductionCompanyDomainModel(
        id = id,
        logoPath = logoPath,
        name = name,
        originCountry = originCountry
    )
}