package com.tnvrhsmi.knowcanada.data.model

import com.tnvrhsmi.knowcanada.ui.adapter.AdapterConstants
import com.tnvrhsmi.knowcanada.ui.adapter.ViewType

data class FactModel (

    val title : String,
    val rows : List<FactListModel>
)

data class FactListModel (

    val title : String,
    val description : String,
    val imageHref : String
) : ViewType {
    override fun getType(): Int = AdapterConstants.CanadaDetailsItem
}