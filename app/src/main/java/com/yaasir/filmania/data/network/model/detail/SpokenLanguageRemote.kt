package com.yaasir.filmania.data.network.model.detail


import com.google.gson.annotations.SerializedName
import com.yaasir.filmania.domain.model.detail.SpokenLanguageDomainModel

data class SpokenLanguageRemote(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("name")
    val name: String
)

fun SpokenLanguageRemote.toDomainModel(): SpokenLanguageDomainModel {
    return SpokenLanguageDomainModel(englishName = englishName, iso6391 = iso6391, name = name)
}