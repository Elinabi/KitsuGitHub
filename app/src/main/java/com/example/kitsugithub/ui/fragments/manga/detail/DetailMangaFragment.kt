package com.example.kitsugithub.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsugithub.R
import com.example.kitsugithub.base.BaseFragment
import com.example.kitsugithub.databinding.FragmentDetailMangaBinding
import com.example.kitsugithub.extension.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMangaFragment :
    BaseFragment<DetailMangaViewModel, FragmentDetailMangaBinding>(R.layout.fragment_detail_manga) {

    override val binding by viewBinding(FragmentDetailMangaBinding::bind)
    override val viewModel by viewModels<DetailMangaViewModel>()
    private val args by navArgs<DetailMangaFragmentArgs>()

    override fun setupSubscribes() = with(binding){
        viewModel.fetchDetailManga(args.id).subscribe(
            onError = {
            },
            onSuccess = { it ->

                it.data.let {
                    itemDetailImg.setImage(it.attributes.posterImage.original)
                    itemBigImg.setImage(it.attributes.posterImage.original)
                    detailNameAnime.text = it.attributes.titles.enJp
                    tvMangaChapters.text = it.attributes.chapterCount.toString()
                    tvMangaStatus.text = it.attributes.status
                    tvMangaPremiered.text = it.attributes.startDate
                    tvMangaAgeRating.text = it.attributes.ageRating
                    detailDescription2.text = it.attributes.description
                }
            }
        )
    }
}