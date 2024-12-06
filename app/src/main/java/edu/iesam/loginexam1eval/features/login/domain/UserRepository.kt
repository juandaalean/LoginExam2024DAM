package edu.iesam.loginexam1eval.features.login.domain

interface UserRepository {

    suspend fun findById(userName: String): User?
    suspend fun save(user: User)
}