package com.example.kitsugithub.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.kitsugithub.base.BaseRepository
import com.example.kitsugithub.data.remote.apiservices.AnimeApiServices
import com.example.kitsugithub.data.repositories.pagingsours.AnimePagingSours
import javax.inject.Inject

class AnimeRepositories  @Inject constructor(
    private val animeApiServices: AnimeApiServices
):BaseRepository() {

    fun fetchAnime() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        AnimePagingSours(animeApiServices)
    }.liveData

    fun fetchAnimeDetail(id: String) = doRequest {
        animeApiServices.fetchAnimeDetail(id)
    }
}