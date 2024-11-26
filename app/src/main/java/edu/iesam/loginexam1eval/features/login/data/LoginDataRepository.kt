package edu.iesam.loginexam1eval.features.login.data

import edu.iesam.loginexam1eval.features.login.domain.User
import edu.iesam.loginexam1eval.features.login.domain.UserRepository

class LoginDataRepository(private val xmlLocal: LoginXmlLocalDataSource): UserRepository {

    override fun findById(userName: String): User? {
        return xmlLocal.findById(userName)
    }

    override fun save(user: User) {
        return xmlLocal.save(user)
    }
}