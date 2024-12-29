package com.example.clear_architecture_base.ui.screens.movies

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.example.clear_architecture_base.core.R
import com.example.clear_architecture_base.core.databinding.FragmentMoviesBinding
import com.example.clear_architecture_base.ui.base.BaseFragment
import com.example.clear_architecture_base.utils.extensions.findNavControllerSafely
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesFragment : BaseFragment<FragmentMoviesBinding, MoviesViewModel>() {
    override val fragmentLayout: Int = R.layout.fragment_movies
    override val viewModel: MoviesViewModel by viewModels()
    private val adapter: MoviesAdapter by lazy {
        MoviesAdapter {
            findNavControllerSafely()?.navigate(MoviesFragmentDirections.actionToMovieDetail(it))
        }
    }

    override fun setupViews() {
        binding.rvPosts.adapter = this@MoviesFragment.adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.posts.collectLatest { pagingData ->
                    adapter.submitData(pagingData)
                }
            }
        }
    }

    override fun handleEvents() {
        adapter.addLoadStateListener {
            viewModel.loading.value = it.refresh == LoadState.Loading
        }
    }
}
