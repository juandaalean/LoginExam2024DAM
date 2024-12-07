package edu.iesam.loginexam1eval.features.login.domain

import org.koin.core.annotation.Single

@Single
class GetRemindUserUseCase(private val repository: UserRepository) {
    operator fun invoke(): User?{
        return repository.getReminderUser()
    }
}