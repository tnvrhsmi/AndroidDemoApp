package com.tnvrhsmi.knowcanada.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tnvrhsmi.knowcanada.data.model.DataFetchListener
import com.tnvrhsmi.knowcanada.data.model.FactListModel
import com.tnvrhsmi.knowcanada.data.model.FactModel
import com.tnvrhsmi.knowcanada.service.FactService
import com.tnvrhsmi.knowcanada.service.FactServiceImpl

class CanadaDetailsListViewModel : DataFetchListener,ViewModel() {
    override fun onDataFetchSuccess(factModel: FactModel) {
        dataFetchState.postValue(DataFetchState.Success(factModel?.rows,factModel.title))
    }

    override fun onDataFetchError(errorMessage: String) {
        dataFetchState.postValue(DataFetchState.Error(errorMessage))
    }

    val dataFetchState: MutableLiveData<DataFetchState> = MutableLiveData()

    private var factService : FactService = FactServiceImpl()

    init {
        fetchData()
    }

    fun fetchData() {
        factService.getFacts(this)
    }
}

sealed class DataFetchState {
    class Success(val factList: List<FactListModel>,val title : String) : DataFetchState()
    class Error(val message: String?) : DataFetchState()
}
