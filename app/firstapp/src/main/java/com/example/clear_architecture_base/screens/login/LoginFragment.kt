package com.example.clear_architecture_base.screens.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.clear_architecture_base.R
import com.example.clear_architecture_base.databinding.FragmentLoginBinding
import com.example.clear_architecture_base.ui.base.BaseFragment
import com.example.clear_architecture_base.utils.extensions.findNavControllerSafely
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class  LoginFragment: BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val fragmentLayout: Int = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            findNavControllerSafely()?.navigate(LoginFragmentDirections.actionToPost())
        }
    }
}