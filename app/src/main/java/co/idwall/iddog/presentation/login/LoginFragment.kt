package co.idwall.iddog.presentation.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import co.idwall.iddog.R
import co.idwall.iddog.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*


import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButton.setOnClickListener {
            viewModel.getUser(emailEditText.text.toString())
        }
        initObserver()
    }

    private fun initObserver() {
        viewModel.actionState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is LoginViewModel.ResponseState.loginSucess -> {
                    val bundle = bundleOf("token" to it.response.user.token)
                    findNavController().navigate(R.id.action_login_to_feed, bundle)
                }
                is LoginViewModel.ResponseState.loginError -> {
                    Toast.makeText(context, it.error.toString(), Toast.LENGTH_LONG)
                }
            }
        })
    }
}