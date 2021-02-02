package com.target.targetcasestudy.domain.usecase

import com.target.targetcasestudy.domain.arch.BaseParamCase
import com.target.targetcasestudy.domain.arch.Either
import com.target.targetcasestudy.domain.arch.Failure
import com.target.targetcasestudy.domain.arch.result
import com.target.targetcasestudy.domain.entity.ProductEntity
import com.target.targetcasestudy.domain.repository.IProductRepository

class ProductUseParamCase(private val repository: IProductRepository) :
    BaseParamCase<ProductEntity, Int>() {

    override suspend fun run(params: Int): Either<Failure, ProductEntity> {
        return repository.getProductDetail(params).result()
    }
}