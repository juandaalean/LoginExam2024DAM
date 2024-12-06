package edu.iesam.loginexam1eval.features.login.domain

import org.koin.core.annotation.Single

@Single
class SingInUseCase(val userRepository: UserRepository) {

    operator fun invoke(userName: String, password: String): Boolean {
        val existingUser = userRepository.findById(userName)
        if (existingUser != null) {
            return false
        }
        userRepository.save(User(userName, password))
        return true
    }
}