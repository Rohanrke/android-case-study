package com.target.targetcasestudy.feature.deals

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.target.targetcasestudy.R
import com.target.targetcasestudy.base.navigation.Navigator
import com.target.targetcasestudy.base.presentation.BaseFragment
import com.target.targetcasestudy.databinding.FragmentDealListBinding
import com.target.targetcasestudy.domain.entity.ProductEntity
import com.target.targetcasestudy.feature.deals.viewmodel.DealViewModel
import com.target.targetcasestudy.feature.deals.viewmodel.ProductViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class DealListFragment : BaseFragment<FragmentDealListBinding>(R.layout.fragment_deal_list) {

    private val productViewModel: ProductViewModel by viewModel()
    private val dealViewModel: DealViewModel by sharedViewModel()

    private var binding: FragmentDealListBinding? = null
    private var itemAdapter: DealItemAdapter? = null

    override fun initComponents(savedInstanceState: Bundle?, binding: FragmentDealListBinding) {
        this.binding = binding
        binding.apply {
            lifecycleOwner = this@DealListFragment
            viewModel = productViewModel
        }
        dealViewModel.updateTitle(getString(R.string.text_deals))
        context?.let {
            initRecyclerView(it)
        }
        productViewModel.fetchProductList()
    }

    private fun initRecyclerView(context: Context) {
        itemAdapter = DealItemAdapter(object : DealItemAdapter.OnDealItemClickListener {
            override fun onDealItemClick(productEntity: ProductEntity) {
                moveToDetail(productEntity.id)
            }
        })
        binding?.run {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = itemAdapter
        }
    }

    override fun observeLiveEvents() {
        productViewModel.productListData.observe(this, {
            itemAdapter?.submitList(it)
        })

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

    private fun moveToDetail(id: Int) {
        val fragment = DealDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(DealDetailFragment.KEY_ID, id)
            }
        }

        activity?.let {
            Navigator.addFragmentEntireScreenWithAnim(
                it.supportFragmentManager,
                fragment,
                R.id.container,
                R.anim.slide_from_right,
                R.anim.slide_out_right,
                DealDetailFragment::class.java.name
            )
        }
    }
}
