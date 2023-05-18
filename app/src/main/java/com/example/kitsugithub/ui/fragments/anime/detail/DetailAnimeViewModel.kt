package com.example.kitsugithub.ui.fragments.anime.detail

import com.example.kitsugithub.base.BaseViewModel
import com.example.kitsugithub.data.repositories.AnimeRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailAnimeViewModel @Inject constructor(
    private val animeRepositories: AnimeRepositories,
) : BaseViewModel() {

    fun fetchDetailAnime(id: String) = animeRepositories.fetchAnimeDetail(id)
}