package edu.iesam.loginexam1eval.features.login.domain

import org.koin.core.annotation.Single

@Single
class SingInUseCase(val userRepository: UserRepository) {

    suspend operator fun invoke(userName: String, password: String): Boolean{
        val user = userRepository.findById(userName).let {
            userRepository.save(User(userName, password))
        }
        return true
    }
}