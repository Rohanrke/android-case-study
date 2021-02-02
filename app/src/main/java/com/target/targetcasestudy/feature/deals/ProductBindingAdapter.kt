package com.target.targetcasestudy.feature.deals

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.target.targetcasestudy.domain.entity.PriceEntity


@BindingAdapter("salePrice", "regularPrice")
fun setSalePrice(
    textView: TextView,
    salePrice: PriceEntity?,
    regularPrice: PriceEntity?
) {
    salePrice?.let { price ->
        textView.text = price.display
        textView.visibility = View.VISIBLE
    } ?: regularPrice?.let { regularPrice ->
        textView.text = regularPrice.display
        textView.visibility = View.VISIBLE
    }
}


@BindingAdapter("regularPrice")
fun setRegularPrice(textView: TextView, regularPrice: PriceEntity?) {
    regularPrice?.let { price ->
        textView.text = price.display
        textView.visibility = View.VISIBLE
    }
}

@BindingAdapter("regularTagVisible")
fun setRegularPriceTag(view: View, regularPrice: PriceEntity?) {
    regularPrice?.let { _ ->
        view.visibility = View.VISIBLE
    }
}


