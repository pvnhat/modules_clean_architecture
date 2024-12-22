package com.example.clear_architecture_base.ui.screens.postlist

import androidx.paging.cachedIn
import com.example.clear_architecture_base.ui.base.BaseViewModel
import com.example.domain.usecase.GetNewestPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getNewestPostsUseCase: GetNewestPostsUseCase
): BaseViewModel() {
    val posts = getNewestPostsUseCase(GetNewestPostsUseCase.Input()).cachedIn(scope)
}
