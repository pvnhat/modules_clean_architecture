package com.example.clear_architecture_base.ui.screens.moviedetail

import androidx.lifecycle.MutableLiveData
import com.example.clear_architecture_base.ui.base.BaseViewModel
import com.example.clear_architecture_base.ui.base.ProcessState
import com.example.domain.entities.MovieModel
import com.example.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : BaseViewModel() {
    val getMovieDetailState = MutableLiveData<ProcessState<MovieModel>>()
    val movie = MutableLiveData<MovieModel>()

    init {
        addSource(getMovieDetailState)
    }

    fun getMovieDetail(id: Int) {
        defaultExecute(getMovieDetailUseCase, GetMovieDetailUseCase.Input(id),getMovieDetailState) {
            getMovieDetailState.value = ProcessState.success(it)
            movie.value = it
        }
    }
}
