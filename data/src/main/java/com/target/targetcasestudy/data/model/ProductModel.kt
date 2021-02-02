package com.target.targetcasestudy.data.model

import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("aisle")
    val aisle: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("regular_price")
    val regularPrice: PriceModel?,
    @SerializedName("sale_price")
    val salePrice: PriceModel?
)
