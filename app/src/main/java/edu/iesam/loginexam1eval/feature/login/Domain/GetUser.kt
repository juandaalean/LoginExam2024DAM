package edu.iesam.loginexam1eval.feature.login.Domain

import edu.iesam.loginexam1eval.feature.login.Data.LoginXmlLocalDataSource

class GetUser(private val xmlLocalDataSource: LoginXmlLocalDataSource): UserRepository {
    override fun getDuplicateUser(id: String) {
        val local = xmlLocalDataSource
        local.findById(id)
    }
}