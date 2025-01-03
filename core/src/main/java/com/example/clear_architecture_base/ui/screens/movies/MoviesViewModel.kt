package com.example.clear_architecture_base.ui.screens.movies

import androidx.paging.cachedIn
import com.example.clear_architecture_base.ui.base.BaseViewModel
import com.example.domain.usecase.GetPopularMoviesUseCase
import com.example.domain.usecase.base.EmptyInput
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    getPopularMoviesUseCase: GetPopularMoviesUseCase
) : BaseViewModel() {
    val posts = getPopularMoviesUseCase(EmptyInput()).cachedIn(scope)
}
