package com.example.kitsugithub.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsugithub.R
import com.example.kitsugithub.base.BaseFragment
import com.example.kitsugithub.databinding.FragmentDetailAnimeBinding

class DetailAnimeFragment :
    BaseFragment<DetailAnimeViewModel, FragmentDetailAnimeBinding>(R.layout.fragment_detail_anime) {

    override val binding by viewBinding(FragmentDetailAnimeBinding::bind)
    override val viewModel by viewModels<DetailAnimeViewModel>()

}