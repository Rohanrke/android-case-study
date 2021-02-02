package com.target.targetcasestudy.domain.usecase

import com.target.targetcasestudy.domain.arch.*
import com.target.targetcasestudy.domain.entity.ProductEntity
import com.target.targetcasestudy.domain.repository.IProductRepository

class ProductListUseCase(private val repository: IProductRepository) :
    BaseCase<List<ProductEntity>>() {
    override suspend fun run(): Either<Failure, List<ProductEntity>> {
        return repository.getProductList().result()
    }
}