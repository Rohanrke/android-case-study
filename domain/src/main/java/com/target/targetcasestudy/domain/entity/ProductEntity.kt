package com.target.targetcasestudy.domain.entity

data class ProductEntity(
    val id: Int, val title: String, val aisle: String,
    val description: String, val imageUrl: String,
    val regularPrice: PriceEntity?, val salePrice: PriceEntity?
)