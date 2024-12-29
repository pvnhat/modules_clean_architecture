package com.example.clear_architecture_base.ui.screens.moviedetail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.clear_architecture_base.core.R
import com.example.clear_architecture_base.core.databinding.FragmentMovieDetailBinding
import com.example.clear_architecture_base.ui.base.BaseFragment
import com.example.clear_architecture_base.utils.extensions.findNavControllerSafely
import com.example.clear_architecture_base.utils.extensions.safeClick
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>() {
    override val fragmentLayout: Int = R.layout.fragment_movie_detail
    override val viewModel: MovieDetailViewModel by viewModels()
    private val args: MovieDetailFragmentArgs by navArgs()

    override fun initData() {
        viewModel.getMovieDetail(args.movieId)
    }

    override fun observes() {
        defaultObserve(viewModel.getMovieDetailState) {
            // No-ops
        }
    }

    override fun handleEvents() {
        binding.btnBack.safeClick {
            findNavControllerSafely()?.popBackStack()
        }
    }
}
