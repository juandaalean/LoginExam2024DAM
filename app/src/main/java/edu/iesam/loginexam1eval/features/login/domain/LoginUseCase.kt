package edu.iesam.loginexam1eval.features.login.domain

import org.koin.core.annotation.Single

@Single
class LoginUseCase(private val userRepository: UserRepository) {
    operator fun invoke(userName: String, password: String): Boolean{
        return userRepository.findById(userName)?.let { existingUser ->
            existingUser.password == password
        }?: false
    }
}