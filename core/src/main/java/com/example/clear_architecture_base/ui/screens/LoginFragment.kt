package com.example.clear_architecture_base.ui.screens

import androidx.fragment.app.viewModels
import com.example.clear_architecture_base.ui.base.BaseFragment
import com.example.core.R
import com.example.core.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val fragmentLayout: Int = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()
}