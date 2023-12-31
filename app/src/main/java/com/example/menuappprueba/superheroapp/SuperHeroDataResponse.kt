package com.example.menuappprueba.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    @SerializedName("response") val isWorking:String,
    @SerializedName("results") val superheroes:List<SuperheroItemResponse>) {
}
data class SuperheroItemResponse(
    @SerializedName("id") val superheroId:String,
    @SerializedName("name") val name:String,
    @SerializedName("image") val SuperherImage:SuperheroImageResponse)
data class SuperheroImageResponse(
    @SerializedName("url") val url:String
)