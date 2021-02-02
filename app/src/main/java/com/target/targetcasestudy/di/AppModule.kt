package com.target.targetcasestudy.di

import com.target.targetcasestudy.utils.NetworkUtils
import org.koin.dsl.module


fun appModule() = module { 
    factory { NetworkUtils(get()) }
}