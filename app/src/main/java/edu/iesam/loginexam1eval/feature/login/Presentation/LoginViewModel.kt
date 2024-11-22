package edu.iesam.loginexam1eval.feature.login.Presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.iesam.loginexam1eval.feature.login.Domain.GetUser

class LoginViewModel(private val getUser: GetUser): ViewModel() {

    private var _uiState = MutableLiveData(getUser)
    private val uiState = _uiState.value

}