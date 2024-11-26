package edu.iesam.loginexam1eval.features.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.features.login.domain.SingInUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val singInUseCase: SingInUseCase) : ViewModel() {

    fun singIn(userName: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = singInUseCase.invoke(userName, password)
            UiState(isSuccess = response )
        }
    }
}

data class UiState(
    var isSuccess: Boolean = false
)