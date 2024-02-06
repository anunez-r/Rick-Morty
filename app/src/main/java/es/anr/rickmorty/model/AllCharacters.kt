package es.anr.rickmorty.model

import com.google.gson.annotations.SerializedName

data class AllCharacters(
    @SerializedName("info") var info: Info? = null,
    @SerializedName("results") var results: List<Character>? = null
)
