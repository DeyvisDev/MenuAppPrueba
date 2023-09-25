package com.example.menuappprueba.superheroapp

import com.google.gson.annotations.SerializedName
import java.net.URL

data class SuperHeroDetailResponse(
    @SerializedName("name") val name:String,
    @SerializedName("powerstats") val powerstats:powerStatsResponse,
    @SerializedName("image") val image:SuperHeroImageDetailResponse
)
data class powerStatsResponse(
    @SerializedName("intelligence") val intelligence:String,
    @SerializedName("strength") val strength:String,
    @SerializedName("speed") val speed:String,
    @SerializedName("durability") val durability:String,
    @SerializedName("power") val power:String,
    @SerializedName("combat") val combat:String
    )
data class SuperHeroImageDetailResponse(
    @SerializedName("url") val url: String
)