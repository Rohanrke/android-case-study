package com.target.targetcasestudy.di.modules

import com.target.targetcasestudy.domain.usecase.ProductListUseCase
import com.target.targetcasestudy.domain.usecase.ProductUseParamCase
import org.koin.dsl.module

fun useCaseModule() = module {
    factory { ProductListUseCase(get()) }
    factory { ProductUseParamCase(get()) }
}