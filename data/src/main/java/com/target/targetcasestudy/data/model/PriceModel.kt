package com.target.targetcasestudy.data.model

import com.google.gson.annotations.SerializedName

data class PriceModel(
    @SerializedName("amount_in_cents")
    val amount: Int,
    @SerializedName("currency_symbol")
    val currency: String,
    @SerializedName("display_string")
    val display: String
)


