package com.yaasir.filmania.data.network.model.detail


import com.google.gson.annotations.SerializedName
import com.yaasir.filmania.domain.model.detail.GenreDomainModel

/**
 * [GenreRemote]
 * Remote model for network layer
 */
data class GenreRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

/**
 * [GenreRemote.toDomainModel]
 * Extension function to convert remote model to domain model
 * @return [GenreDomainModel]
 */
fun GenreRemote.toDomainModel(): GenreDomainModel {
    return GenreDomainModel(id = id, name = name)
}