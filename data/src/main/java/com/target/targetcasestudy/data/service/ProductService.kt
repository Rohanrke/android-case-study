package com.target.targetcasestudy.data.service

import com.target.targetcasestudy.data.model.ProductModel
import com.target.targetcasestudy.data.response.ProductListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("deals")
    suspend fun getProductListing(): ProductListResponse

    @GET("deals/{id}")
    suspend fun getProduct(@Path("id") id: Int): ProductModel
}