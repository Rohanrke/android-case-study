package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.data.FailureHandler
import com.target.targetcasestudy.data.mapper.product.ProductMapper
import com.target.targetcasestudy.data.service.ProductService
import com.target.targetcasestudy.domain.arch.ResultState
import com.target.targetcasestudy.domain.entity.ProductEntity
import com.target.targetcasestudy.domain.repository.IProductRepository

class ProductRepositoryImpl(
    private val remote: ProductService,
    private val mapper: ProductMapper,
    private val failureHandler: FailureHandler
) : IProductRepository {

    override suspend fun getProductList(): ResultState<List<ProductEntity>> {
        return try {
            val response = remote.getProductListing()
            ResultState.Success(response.products.map {
                mapper.map(it)
            })
        } catch (ex: Exception) {
            ResultState.Error(failureHandler.handleException(ex))
        }
    }

    override suspend fun getProductDetail(productId: Int): ResultState<ProductEntity> {
        return try {
            val response = remote.getProduct(productId)
            ResultState.Success(mapper.map(response))
        } catch (ex: Exception) {
            ResultState.Error(failureHandler.handleException(ex))
        }
    }
}