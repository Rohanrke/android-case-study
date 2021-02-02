package com.target.targetcasestudy.data.response

import com.google.gson.annotations.SerializedName
import com.target.targetcasestudy.data.model.ProductModel

data class ProductListResponse(
    @SerializedName("products")
    val products: List<ProductModel>
)