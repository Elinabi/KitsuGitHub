package com.example.kitsugithub.ui.fragments.manga

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.kitsugithub.base.BaseViewModel
import com.example.kitsugithub.data.repositories.MangaRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel  @Inject constructor(
    private val mangaRepositories: MangaRepositories
): BaseViewModel() {

    fun fetchManga() = mangaRepositories.fetchManga().cachedIn(viewModelScope)
}