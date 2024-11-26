package edu.iesam.loginexam1eval.features.login.domain

class SingInUseCase(val userRepository: UserRepository) {

    operator fun invoke(userName: String, password: String): Boolean{
        val user = userRepository.findById(userName).let {
            userRepository.save(User(userName,userName, password))
        }
        return true
    }
}