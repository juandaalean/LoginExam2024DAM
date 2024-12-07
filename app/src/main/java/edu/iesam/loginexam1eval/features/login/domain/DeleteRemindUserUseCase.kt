package edu.iesam.loginexam1eval.features.login.domain

import org.koin.core.annotation.Single

@Single
class DeleteRemindUserUseCase(private val userRepository: UserRepository) {
    operator fun invoke(){
        userRepository.deleteRemindUser()
    }
}