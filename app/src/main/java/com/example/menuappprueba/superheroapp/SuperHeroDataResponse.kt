package com.example.menuappprueba.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(@SerializedName("response") val isWorking:String) {
}