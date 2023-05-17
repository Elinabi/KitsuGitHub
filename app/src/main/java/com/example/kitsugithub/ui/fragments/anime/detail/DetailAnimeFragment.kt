package com.example.kitsugithub.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsugithub.R
import com.example.kitsugithub.base.BaseFragment
import com.example.kitsugithub.databinding.FragmentDetailAnimeBinding
import com.example.kitsugithub.extension.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailAnimeFragment :
    BaseFragment<DetailAnimeViewModel, FragmentDetailAnimeBinding>(R.layout.fragment_detail_anime) {

    override val binding by viewBinding(FragmentDetailAnimeBinding::bind)
    override val viewModel by viewModels<DetailAnimeViewModel>()
    private val args by navArgs<DetailAnimeFragmentArgs>()

    override fun setupSubscribes() = with(binding){
        viewModel.fetchDetailAnime(args.id).subscribe(
            onError = {
            },
            onSuccess = { it ->
                it.data.let {
                    itemDetailImg.setImage(it.attributes.posterImage.original)
                    itemBigImg.setImage(it.attributes.posterImage.original)
                    detailNameAnime.text = it.attributes.titles.enJp
                    tvAnimeEpisodes.text = it.attributes.episodeCount.toString()
                    tvAnimeStatus.text = it.attributes.status
                    tvAnimePremiered.text = it.attributes.startDate
                    tvAnimeAgeRating.text = it.attributes.ageRatingGuide
                    detailDescription.text = it.attributes.description
                }
            }
        )
    }
}