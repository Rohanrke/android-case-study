package com.target.targetcasestudy.di.modules

import com.target.targetcasestudy.data.FailureHandler
import org.koin.dsl.module


fun mainModule() = module {
    factory { FailureHandler() }
}