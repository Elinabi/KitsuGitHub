package com.example.kitsugithub.data.remote.apiservices

import com.example.kitsugithub.Models.Anime
import com.example.kitsugithub.Models.DataItem
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiServices {

    @GET("edge/anime")
    suspend fun fetchAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int,
    ): Anime<DataItem>
}