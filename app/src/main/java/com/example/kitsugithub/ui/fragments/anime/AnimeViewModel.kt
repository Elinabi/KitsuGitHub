package com.example.kitsugithub.ui.fragments.anime

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.kitsugithub.base.BaseViewModel
import com.example.kitsugithub.data.repositories.AnimeRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeRepositories: AnimeRepositories
): BaseViewModel() {

    fun fetchAnime() = animeRepositories.fetchAnime().cachedIn(viewModelScope)
}