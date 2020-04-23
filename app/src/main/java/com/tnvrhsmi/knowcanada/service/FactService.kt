package com.tnvrhsmi.knowcanada.service

import com.tnvrhsmi.knowcanada.data.model.DataFetchListener

interface FactService {
    fun getFacts(dataFetchListener: DataFetchListener)
}