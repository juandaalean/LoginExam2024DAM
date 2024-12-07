package edu.iesam.loginexam1eval.features.login.data

import edu.iesam.loginexam1eval.features.login.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.features.login.data.local.UserRemindXmlLocalDataSource
import edu.iesam.loginexam1eval.features.login.domain.User
import edu.iesam.loginexam1eval.features.login.domain.UserRepository
import org.koin.core.annotation.Single

@Single
class LoginDataRepository(
    private val xmlLocal: LoginXmlLocalDataSource,
    private val userRemindXmlLocalDataSource: UserRemindXmlLocalDataSource
): UserRepository {

    override fun findById(userName: String): User? {
        return xmlLocal.findById(userName)
    }

    override fun save(user: User) {
        return xmlLocal.save(user)
    }

    override fun getReminderUser(): User? {
        return userRemindXmlLocalDataSource.findReminderUser()
    }

    override fun saveUserLogged(user: User) {
        userRemindXmlLocalDataSource.saveUser(user)
    }

    override fun deleteRemindUser() {
         userRemindXmlLocalDataSource.deleteUser()
    }

    override fun deleteUserById(userName: String) {
        xmlLocal.deleteById(userName)
    }
}