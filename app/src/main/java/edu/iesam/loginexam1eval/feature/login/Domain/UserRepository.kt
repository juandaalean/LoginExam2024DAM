package edu.iesam.loginexam1eval.feature.login.Domain

interface UserRepository {

    fun getDuplicateUser(id: String)

}