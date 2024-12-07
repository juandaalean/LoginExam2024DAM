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
import edu.iesam.loginexam1eval.features.login.domain.User
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
            if (binding.reminder.isChecked) {
                viewModel.rememberUser(User(userName, password))
            } else {
                viewModel.deleteRemindUser()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        navigateToDeleteUser()
        navigateToSingIn()
        viewModel.getRemindUser()
    }

    private fun setupObserver() {
        val observer = Observer<UserViewModel.UiState> { uiState ->
            uiState.user?.let { user ->
                binding.username.setText(user.userName)
                binding.password.setText(user.password)
            }
            binding.reminder.isChecked = true
            uiState.isSuccess?.let { isSuccess ->
                if (isSuccess) {
                    Log.d("@JuanDev", "Login...")
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

    private fun navigateToDeleteUser() {
        binding.deleteUser.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionFromLoginToDeleteUser())
        }
    }

    private fun navigateToWelcome() {
        findNavController().navigate(LoginFragmentDirections.actionFromLoginToWelcome())
    }
}