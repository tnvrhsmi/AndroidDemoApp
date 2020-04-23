package com.tnvrhsmi.knowcanada.data.model

interface DataFetchListener {
    fun onDataFetchSuccess(factModel: FactModel)
    fun onDataFetchError(errorMessage: String)
}