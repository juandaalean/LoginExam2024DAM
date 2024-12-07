package edu.iesam.loginexam1eval.features.login.domain

import org.koin.core.annotation.Single

@Single
class RememberUserUseCase(private val userRepository: UserRepository) {
    operator fun invoke(user: User){
        userRepository.saveUserLogged(user)
    }
}