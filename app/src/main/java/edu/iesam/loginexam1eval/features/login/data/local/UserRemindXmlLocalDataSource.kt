package edu.iesam.loginexam1eval.features.login.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.loginexam1eval.features.login.domain.User
import org.koin.core.annotation.Single

@Single
class UserRemindXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        "user-reminder-storage", Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun saveUser(user: User) {
        val editor = sharedPref.edit()
        editor.putString("user", gson.toJson(user))
        editor.apply()
    }

    fun findReminderUser(): User? {
        val storedUser = sharedPref.getString("user", null)
        return gson.fromJson(storedUser, User::class.java)
    }

    fun deleteUser() {
        sharedPref.edit().clear().apply()
    }
}
