package com.example.kitsugithub.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsugithub.R
import com.example.kitsugithub.base.BaseFragment
import com.example.kitsugithub.databinding.FragmentAnimeBinding
import com.example.kitsugithub.ui.adapter.AnimeAdapter
import com.example.kitsugithub.ui.fragments.tablayout.TabLayoutFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment :
    BaseFragment<AnimeViewModel, FragmentAnimeBinding>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel by viewModels<AnimeViewModel>()
    private var animeAdapter = AnimeAdapter(this::onItemClick)

    override fun initialise() {
        binding.animeRecView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupObserves() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }
    private fun onItemClick(id: String) {
        findNavController().navigate(TabLayoutFragmentDirections.actionTabLayoutFragmentToDetailAnimeFragment(
            id))
    }
}