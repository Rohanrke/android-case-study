package com.target.targetcasestudy

import android.app.Application
import com.target.targetcasestudy.di.appModule
import com.target.targetcasestudy.di.modules.*
import com.target.targetcasestudy.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RetailApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RetailApplication)
            modules(
                mutableListOf(
                    viewModelModule(),
                    repositoryModule(),
                    retrofitModule(),
                    useCaseModule(),
                    mapperModule(),
                    mainModule(),
                    appModule()
                )
            )

        }
    }
}