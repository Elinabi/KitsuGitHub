package com.example.kitsugithub.ui.fragments.manga.detail

import com.example.kitsugithub.base.BaseViewModel
import com.example.kitsugithub.data.repositories.MangaRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMangaViewModel @Inject constructor(
    private val mangaRepositories: MangaRepositories
): BaseViewModel() {

    fun fetchDetailManga(id: String) = mangaRepositories.fetchMangaDetail(id)
}