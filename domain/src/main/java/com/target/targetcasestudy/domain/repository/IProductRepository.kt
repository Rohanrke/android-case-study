package com.target.targetcasestudy.domain.repository

import com.target.targetcasestudy.domain.arch.ResultState
import com.target.targetcasestudy.domain.entity.ProductEntity

interface IProductRepository {

    suspend fun getProductList(): ResultState<List<ProductEntity>>

    suspend fun getProductDetail(productId: Int): ResultState<ProductEntity>
}