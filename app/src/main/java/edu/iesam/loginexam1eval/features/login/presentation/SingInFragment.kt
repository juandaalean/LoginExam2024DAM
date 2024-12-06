package edu.iesam.loginexam1eval.features.login.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.loginexam1eval.databinding.FragmentSingInBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SingInFragment : Fragment() {

    private val viewModel: UserViewModel by viewModel()

    private var _binding: FragmentSingInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSingInBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.action.setOnClickListener {
            val userName = binding.username.text.toString()
            val password = binding.password.text.toString()
            viewModel.singIn(userName, password)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
    }

    private fun setupObserver() {
        val userObserver = Observer<UserViewModel.UiState>{ uiState ->
            uiState.isSuccess?.let { isSuccess ->
                if (isSuccess){
                    Log.d("@JuanDev", "The user has been saved")
                    navigateToLogin()
                } else {
                    Log.d("@JuanDev", "The user already exists")
                }
            }

        }
        viewModel.uiState.observe(viewLifecycleOwner, userObserver)
    }

    private fun navigateToWelcome(){
        findNavController().navigate(SingInFragmentDirections.actionFromSingInToWelcome())
    }

    private fun navigateToLogin(){
        findNavController().navigate(SingInFragmentDirections.actionFromSingInToLogin())
    }
}
