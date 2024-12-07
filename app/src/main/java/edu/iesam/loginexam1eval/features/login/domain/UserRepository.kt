package edu.iesam.loginexam1eval.features.login.domain

interface UserRepository {

    fun findById(userName: String): User?
    fun save(user: User)
    fun getReminderUser() : User?
    fun saveUserLogged(user: User)
    fun deleteRemindUser()
    fun deleteUserById(userName: String)
}