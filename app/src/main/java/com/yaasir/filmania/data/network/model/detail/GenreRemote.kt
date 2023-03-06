package com.yaasir.filmania.data.network.model.detail


import com.google.gson.annotations.SerializedName
import com.yaasir.filmania.domain.model.detail.GenreDomainModel

data class GenreRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

fun GenreRemote.toDomainModel(): GenreDomainModel {
    return GenreDomainModel(id = id, name = name)
}