package com.example.kitsugithub.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsugithub.R
import com.example.kitsugithub.base.BaseFragment
import com.example.kitsugithub.databinding.FragmentMangaBinding
import com.example.kitsugithub.ui.adapter.MangaAdapter
import com.example.kitsugithub.ui.fragments.tablayout.TabLayoutFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment :
    BaseFragment<MangaViewModel, FragmentMangaBinding>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel by viewModels<MangaViewModel>()
    private var animeAdapter = MangaAdapter(this::onItemClick)

    override fun initialise() {
        binding.mangaRecView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupObserves() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(TabLayoutFragmentDirections.actionTabLayoutFragmentToDetailMangaFragment (id))
    }
}