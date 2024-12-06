package edu.iesam.loginexam1eval.features.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.features.login.domain.LoginUseCase
import edu.iesam.loginexam1eval.features.login.domain.SingInUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UserViewModel(
    private val singInUseCase: SingInUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private var _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun singIn(userName: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = singInUseCase.invoke(userName, password)
            _uiState.postValue(
                UiState(isSuccess = response)
            )
        }
    }

    fun login(userName: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = loginUseCase.invoke(userName, password)
            _uiState.postValue(
                UiState(
                    isSuccess = response
                )
            )
        }
    }

    data class UiState(
        var isSuccess: Boolean = false
    )
}

