package com.example.menuappprueba.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/2180089478847111/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String):Response<SuperHeroDataResponse>

    @GET("/api/2180089478847111/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId:String):Response<>

}