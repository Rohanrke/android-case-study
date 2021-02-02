package com.target.targetcasestudy.feature.deals.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.target.targetcasestudy.base.presentation.BaseViewModel
import kotlin.coroutines.CoroutineContext

class DealViewModel(
    private val context: CoroutineContext
) : BaseViewModel() {

    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    var selectedId: Int? = null


    fun updateTitle(titleString: String) {
        _title.postValue(titleString)
    }

}