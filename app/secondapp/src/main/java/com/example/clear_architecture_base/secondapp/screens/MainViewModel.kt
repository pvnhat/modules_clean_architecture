package com.example.clear_architecture_base.secondapp.screens

import com.example.clear_architecture_base.ui.base.BaseViewModel
import com.example.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getMovieDetailUseCase: GetMovieDetailUseCase
) : BaseViewModel()
