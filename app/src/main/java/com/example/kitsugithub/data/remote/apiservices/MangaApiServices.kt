package com.example.kitsugithub.data.remote.apiservices

import com.example.kitsugithub.models.Anime
import com.example.kitsugithub.models.DataItem
import com.example.kitsugithub.models.ResponseData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiServices {

    @GET("edge/manga")
    suspend fun fetchManga(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int,
    ): Anime<DataItem>

    @GET("edge/manga/{id}")
    suspend fun fetchMangaDetail(@Path("id") id: String): ResponseData
}