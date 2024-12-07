package edu.iesam.loginexam1eval.features.login.domain

import org.koin.core.annotation.Single

@Single
class DeleteUserUseCase(private val userRepository: UserRepository) {
    operator fun invoke(userName: String, password: String): Boolean{
        val user = userRepository.findById(userName)?.let { user ->
            if (user.password == password){
                userRepository.deleteUserById(userName)
                return true
            }
        }
        return false
    }
}