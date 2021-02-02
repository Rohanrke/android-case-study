package com.target.targetcasestudy.feature.deals.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.target.targetcasestudy.R
import com.target.targetcasestudy.base.presentation.BaseViewModel
import com.target.targetcasestudy.base.presentation.ProgressState
import com.target.targetcasestudy.domain.arch.Failure

import com.target.targetcasestudy.domain.entity.ProductEntity
import com.target.targetcasestudy.domain.usecase.ProductListUseCase
import com.target.targetcasestudy.domain.usecase.ProductUseParamCase
import com.target.targetcasestudy.utils.NetworkUtils
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ProductViewModel(
    private val context: CoroutineContext,
    private val productListUseCase: ProductListUseCase,
    private val productUseCase: ProductUseParamCase,
    private val networkUtils: NetworkUtils
) : BaseViewModel() {

    private val _productListData = MutableLiveData<List<ProductEntity>>()
    val productListData: LiveData<List<ProductEntity>>
        get() = _productListData

    private val _productData = MutableLiveData<ProductEntity>()
    val productData: LiveData<ProductEntity>
        get() = _productData


    fun fetchProductList() {
        if(_productListData.value == null) {
            viewModelScope.launch(context) {
                if (!networkUtils.isNetworkAvailable()){
                    _errorMessageRes.postValue(R.string.no_network)
                    return@launch
                }
                _state.postValue(ProgressState.LOADING)
                productListUseCase.invoke(this) {
                    it.either(
                        ::onFailure,
                        ::onProductLisSuccess
                    )
                }
            }
        }
    }

    fun fetchProductDetails(id: Int) {
        viewModelScope.launch(context) {
            if (!networkUtils.isNetworkAvailable()){
                _errorMessageRes.postValue(R.string.no_network)
                return@launch
            }
            _state.postValue(ProgressState.LOADING)
            productUseCase.invoke(this, id) {
                it.either(
                    ::onFailure,
                    ::onProductSuccess
                )
            }
        }
    }

    @VisibleForTesting
    private fun onFailure(failure: Failure) {
        _state.postValue(ProgressState.ERROR)
        _errorMessage.postValue(failure.message)
    }

    @VisibleForTesting
    private fun onProductLisSuccess(list: List<ProductEntity>) {
        _state.postValue(ProgressState.SUCCESS)
        _productListData.postValue(list)
    }

    @VisibleForTesting
    fun onProductSuccess(entity: ProductEntity) {
        _state.postValue(ProgressState.SUCCESS)
        _productData.postValue(entity)
    }

}