package com.target.targetcasestudy.di

import com.target.targetcasestudy.feature.deals.viewmodel.DealViewModel
import com.target.targetcasestudy.feature.deals.viewmodel.ProductViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel { ProductViewModel(Dispatchers.IO, get(), get(), get()) }
    viewModel { DealViewModel(Dispatchers.IO) }
}

