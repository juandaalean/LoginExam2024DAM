package edu.iesam.loginexam1eval.features.login.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.loginexam1eval.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val viewModel: UserViewModel by viewModel()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.action.setOnClickListener {
            val userName = binding.username.text.toString()
            val password = binding.password.text.toString()
            viewModel.login(userName, password)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        navigateToSingIn()
    }

    private fun setupObserver() {
        val observer = Observer<UserViewModel.UiState> { uiState ->
            uiState.isSuccess?.let { isSuccess ->
                if (isSuccess) {
                    Log.d("@JuanDev", "Login in...")
                    navigateToWelcome()
                } else {
                    Log.d("@JuanDev", "Your password or username are wrong, please try again.")
                }
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun navigateToSingIn() {
        binding.singIn.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionFromLoginToSingIn())
        }
    }

    private fun navigateToWelcome() {
        findNavController().navigate(LoginFragmentDirections.actionFromLoginToWelcome())
    }
}