package edu.iesam.loginexam1eval.features.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.features.login.domain.DeleteRemindUserUseCase
import edu.iesam.loginexam1eval.features.login.domain.DeleteUserUseCase
import edu.iesam.loginexam1eval.features.login.domain.GetRemindUserUseCase
import edu.iesam.loginexam1eval.features.login.domain.LoginUseCase
import edu.iesam.loginexam1eval.features.login.domain.RememberUserUseCase
import edu.iesam.loginexam1eval.features.login.domain.SingInUseCase
import edu.iesam.loginexam1eval.features.login.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UserViewModel(
    private val singInUseCase: SingInUseCase,
    private val loginUseCase: LoginUseCase,
    private val rememberUserUseCase: RememberUserUseCase,
    private val getRemindUserUseCase: GetRemindUserUseCase,
    private val deleteRemindUserUseCase: DeleteRemindUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
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

    fun deleteUser(userName: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = deleteUserUseCase.invoke(userName, password)
            _uiState.postValue(
                UiState(isSuccess = response)
            )
        }
    }

    fun getRemindUser() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getRemindUserUseCase.invoke()
            _uiState.postValue(UiState(user = response))
        }

    }

    fun rememberUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            rememberUserUseCase.invoke(user)
        }
    }

    fun deleteRemindUser() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteRemindUserUseCase.invoke()
        }
    }


    data class UiState(
        var user: User? = null,
        var isSuccess: Boolean = false
    )
}

