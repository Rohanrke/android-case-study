package com.target.targetcasestudy.feature.deals

import android.os.Bundle
import com.target.targetcasestudy.base.presentation.BaseFragment
import com.target.targetcasestudy.databinding.FragmentDealDetailBinding
import com.target.targetcasestudy.R
import com.target.targetcasestudy.feature.deals.viewmodel.DealViewModel
import com.target.targetcasestudy.feature.deals.viewmodel.ProductViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DealDetailFragment : BaseFragment<FragmentDealDetailBinding>(R.layout.fragment_deal_detail) {

    private val productViewModel: ProductViewModel by viewModel()
    private val dealViewModel: DealViewModel by sharedViewModel()

    override fun initComponents(savedInstanceState: Bundle?, binding: FragmentDealDetailBinding) {
        binding.apply {
            lifecycleOwner = this@DealDetailFragment
            viewModel = productViewModel
        }
        dealViewModel.updateTitle(getString(R.string.text_details))
        val id = arguments?.getInt(KEY_ID) ?: dealViewModel.selectedId
        id?.let {
            productViewModel.fetchProductDetails(it)
        }
    }

    override fun observeLiveEvents() {
        productViewModel.errorMessage.observe(this, { message ->
            activity?.let {
                showErrorMessage(it, message)
            }
        })

        productViewModel.errorMessageRes.observe(this, { message ->
            activity?.let {
                showErrorMessage(it, getString(message))
            }
        })
    }


    companion object {
        const val KEY_ID = "productId"
    }

}