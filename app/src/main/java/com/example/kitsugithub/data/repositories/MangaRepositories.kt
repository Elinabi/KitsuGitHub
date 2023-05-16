package com.example.kitsugithub.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.kitsugithub.base.BaseRepository
import com.example.kitsugithub.data.remote.apiservices.MangaApiServices
import com.example.kitsugithub.data.repositories.pagingsours.MangaPagingSours
import javax.inject.Inject

class MangaRepositories  @Inject constructor(
    private val mangaApiServices: MangaApiServices
):BaseRepository() {

    fun fetchManga() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        MangaPagingSours(mangaApiServices)
    }.liveData
}