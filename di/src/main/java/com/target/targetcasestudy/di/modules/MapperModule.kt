package com.target.targetcasestudy.di.modules

import com.target.targetcasestudy.data.mapper.product.PriceMapper
import com.target.targetcasestudy.data.mapper.product.ProductMapper
import org.koin.dsl.module

fun mapperModule() = module {
    factory { PriceMapper() }
    factory { ProductMapper(get()) }
}