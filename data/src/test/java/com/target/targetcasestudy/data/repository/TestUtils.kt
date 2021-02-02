package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.data.model.PriceModel
import com.target.targetcasestudy.data.model.ProductModel
import com.target.targetcasestudy.domain.entity.PriceEntity
import com.target.targetcasestudy.domain.entity.ProductEntity

object TestUtils {

    fun getProductModelList() = arrayListOf(
        getProductModel()
    )

    fun getProductEntityList() = arrayListOf(
        getProductEntity()
    )

    fun getProductModel() = ProductModel(
        id = 0,
        title = "non mollit veniam ex",
        aisle = "b2",
        description = "minim ad et minim ipsum duis irure pariatur deserunt eu cillum anim ipsum velit tempor eu pariatur sunt mollit tempor ut tempor exercitation occaecat ad et veniam et excepteur velit esse eu et ut\n" +
                "     * ipsum consectetur aliquip do quis voluptate cupidatat eu ut consequat adipisicing occaecat adipisicing proident laborum laboris deserunt in laborum \n" +
                "     * est anim ad non",
        imageUrl = "https://picsum.photos/id/0/300/300",
        regularPrice = PriceModel(amount = 18406, currency = "$", display = "$184.06"),
        salePrice = null
    )


    fun getProductEntity() = ProductEntity(
        id = 0,
        title = "non mollit veniam ex",
        aisle = "b2",
        description = "minim ad et minim ipsum duis irure pariatur deserunt eu cillum anim ipsum velit tempor eu pariatur sunt mollit tempor ut tempor exercitation occaecat ad et veniam et excepteur velit esse eu et ut\n" +
                "     * ipsum consectetur aliquip do quis voluptate cupidatat eu ut consequat adipisicing occaecat adipisicing proident laborum laboris deserunt in laborum \n" +
                "     * est anim ad non",
        imageUrl = "https://picsum.photos/id/0/300/300",
        regularPrice = PriceEntity(amount = 18406, currency = "$", display = "$184.06"),
        salePrice = null
    )

}