package com.target.targetcasestudy.data.mapper.product

import com.target.targetcasestudy.data.mapper.RemoteToEntityMapper
import com.target.targetcasestudy.data.model.ProductModel
import com.target.targetcasestudy.domain.entity.ProductEntity

class ProductMapper(private val priceMapper: PriceMapper) :
    RemoteToEntityMapper<ProductModel, ProductEntity> {

    override fun map(remote: ProductModel): ProductEntity {
        return ProductEntity(
            id = remote.id,
            title = remote.title,
            aisle = remote.aisle,
            description = remote.description,
            imageUrl = remote.imageUrl,
            regularPrice = remote.regularPrice?.let {
                priceMapper.map(it)
            },
            salePrice = remote.salePrice?.let {
                priceMapper.map(it)
            }
        )

    }
}