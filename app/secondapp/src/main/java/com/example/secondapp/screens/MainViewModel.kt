package com.example.secondapp.screens

import com.example.clear_architecture_base.ui.base.BaseViewModel
import com.example.domain.usecase.GetPostDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getPostDetailUseCase: GetPostDetailUseCase
) : BaseViewModel() {
}