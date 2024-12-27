package com.example.clear_architecture_base.ui.screens.postdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.clear_architecture_base.core.R
import com.example.clear_architecture_base.core.databinding.FragmentPostsBinding
import com.example.clear_architecture_base.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailFragment : BaseFragment<FragmentPostsBinding, PostDetailViewModel>() {
    override val fragmentLayout: Int = R.layout.fragment_post_detail
    override val viewModel: PostDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
