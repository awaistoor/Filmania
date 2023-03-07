package com.yaasir.filmania.data.network.model.detail


import com.google.gson.annotations.SerializedName
import com.yaasir.filmania.domain.model.detail.ProductionCountryDomainModel

/**
 * [ProductionCountryRemote]
 * Remote model for network layer
 */
data class ProductionCountryRemote(
    @SerializedName("iso_3166_1")
    val iso31661: String,
    @SerializedName("name")
    val name: String
)

/**
 * [ProductionCountryRemote.toDomainModel]
 * Extension function to convert remote model to domain model
 * @return [ProductionCountryDomainModel]
 */
fun ProductionCountryRemote.toDomainModel(): ProductionCountryDomainModel {
    return ProductionCountryDomainModel(
        iso31661 = iso31661, name = name
    )
}