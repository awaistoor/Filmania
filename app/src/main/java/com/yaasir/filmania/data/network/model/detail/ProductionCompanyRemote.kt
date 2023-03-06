package com.yaasir.filmania.data.network.model.detail


import com.google.gson.annotations.SerializedName
import com.yaasir.filmania.domain.model.detail.ProductionCompanyDomainModel

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

fun ProductionCompanyRemote.toDomainModel(): ProductionCompanyDomainModel {
    return ProductionCompanyDomainModel(
        id = id,
        logoPath = logoPath,
        name = name,
        originCountry = originCountry
    )
}