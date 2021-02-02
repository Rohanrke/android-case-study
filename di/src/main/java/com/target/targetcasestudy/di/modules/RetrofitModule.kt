package com.target.targetcasestudy.di.modules

import com.google.gson.GsonBuilder
import com.target.targetcasestudy.data.service.ProductService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.target.com/mobile_case_study_deals/v1/"
fun retrofitModule() = module {
    single { provideLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single {
        provideRetrofit(
            BASE_URL,
            get(),
            GsonConverterFactory.create(GsonBuilder().create())
        )
    }
    single { provideUserService(get()) }
}

/*
 * The method returns the Retrofit object
 * */
fun provideRetrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient.Builder,
    factory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder().client(okHttpClient.build())
        .addConverterFactory(factory)
        .baseUrl(baseUrl)
        .build()
}


fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(httpLoggingInterceptor)
    return httpClient
}

fun provideUserService(retrofit: Retrofit): ProductService = retrofit.create(ProductService::class.java)
