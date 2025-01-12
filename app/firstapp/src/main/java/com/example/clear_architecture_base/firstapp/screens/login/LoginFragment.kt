package com.example.clear_architecture_base.firstapp.screens.login

import androidx.fragment.app.viewModels
import com.example.clear_architecture_base.app.firstapp.R
import com.example.clear_architecture_base.app.firstapp.databinding.FragmentLoginBinding
import com.example.clear_architecture_base.ui.base.BaseFragment
import com.example.clear_architecture_base.utils.extensions.findNavControllerSafely
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val fragmentLayout: Int = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()

    override fun handleEvents() {
        binding.btnLogin.setOnClickListener {
            viewModel.login(
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString()
            )
        }
    }

    override fun observes() {
        defaultObserve(viewModel.loginState) {
            findNavControllerSafely()?.navigate(LoginFragmentDirections.actionToPost())
        }
    }
}
