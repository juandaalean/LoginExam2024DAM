package edu.iesam.loginexam1eval.app

import android.app.Application
import edu.iesam.loginexam1eval.app.di.AppModule
import edu.iesam.loginexam1eval.features.login.di.UserModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class LoginExam1App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LoginExam1App)
            modules(
                AppModule().module,
                UserModule().module
            )
        }
    }
}