package edu.iesam.loginexam1eval.features.login.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.loginexam1eval.databinding.FragmentDeleteUserBinding
import edu.iesam.loginexam1eval.features.login.domain.User
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeleteUserFragment : Fragment() {

    private val viewModel: UserViewModel by viewModel()

    private var _binding: FragmentDeleteUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeleteUserBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.action.setOnClickListener {
            val userName = binding.username.text.toString()
            val password = binding.password.text.toString()
            viewModel.deleteUser(userName, password)
            viewModel.deleteRemindUser()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
    }

    private fun setupObserver() {
        val userObserver = Observer<UserViewModel.UiState> { uiState ->
            uiState.isSuccess?.let { isSuccess ->
                if (isSuccess) {
                    Log.d("@JuanDev", "The user has been deleted")
                    navigateToLogin()
                } else {
                    Log.d("@JuanDev", "Your username or password are wrong.")
                }
            }

        }
        viewModel.uiState.observe(viewLifecycleOwner, userObserver)
    }

    private fun navigateToLogin() {
        findNavController().navigate(DeleteUserFragmentDirections.actionFromDeleteUserToLogin())
    }
}
