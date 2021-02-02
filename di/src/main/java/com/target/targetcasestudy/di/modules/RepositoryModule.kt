package com.target.targetcasestudy.di.modules

import com.target.targetcasestudy.data.repository.ProductRepositoryImpl
import com.target.targetcasestudy.domain.repository.IProductRepository
import org.koin.dsl.module

fun repositoryModule() = module {
    factory<IProductRepository> { ProductRepositoryImpl(get(), get(), get()) }
}