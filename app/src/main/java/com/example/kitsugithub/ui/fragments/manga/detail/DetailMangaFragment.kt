package com.example.kitsugithub.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsugithub.R
import com.example.kitsugithub.base.BaseFragment
import com.example.kitsugithub.databinding.FragmentDetailMangaBinding

class DetailMangaFragment :
    BaseFragment<DetailMangaViewModel, FragmentDetailMangaBinding>(R.layout.fragment_detail_anime) {

    override val binding by viewBinding(FragmentDetailMangaBinding::bind)
    override val viewModel by viewModels<DetailMangaViewModel>()

}