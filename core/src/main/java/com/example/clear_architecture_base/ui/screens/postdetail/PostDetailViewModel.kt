package com.example.clear_architecture_base.ui.screens.postdetail

import com.example.clear_architecture_base.ui.base.BaseViewModel
import com.example.domain.usecase.GetPostDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val getPostDetailUseCase: GetPostDetailUseCase
) : BaseViewModel() {
}
