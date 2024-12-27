package com.example.clear_architecture_base.ui.screens.postlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.clear_architecture_base.core.R
import com.example.clear_architecture_base.core.databinding.FragmentPostsBinding
import com.example.clear_architecture_base.ui.base.BaseFragment
import com.example.clear_architecture_base.utils.extensions.findNavControllerSafely
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostsFragment : BaseFragment<FragmentPostsBinding, PostsViewModel>() {
    override val fragmentLayout: Int = R.layout.fragment_posts
    override val viewModel: PostsViewModel by viewModels()
    private val adapter: PostsAdapter by lazy {
        PostsAdapter {
            findNavControllerSafely()?.navigate(PostsFragmentDirections.actionToPostDetail())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPosts.adapter = this@PostsFragment.adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.posts.collectLatest { pagingData ->
                    adapter.submitData(pagingData)
                }
            }
        }
    }
}
