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
        dataFetchState.postValue(DataFetchState.Success(factModel?.rows)) //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDataFetchError(errorMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val dataFetchState: MutableLiveData<DataFetchState> = MutableLiveData()

    private var factService : FactService = FactServiceImpl()

    init {
        factService.getFacts(this)
    }
}

sealed class DataFetchState {
    class Success(val factList: List<FactListModel>) : DataFetchState()
    class Error(val message: String?) : DataFetchState()
}
