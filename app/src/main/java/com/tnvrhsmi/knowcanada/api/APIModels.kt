package com.tnvrhsmi.knowcanada.api

data class Fact (

    val title : String,
    val rows : List<Rows>
)

data class Rows (

    val title : String,
    val description : String,
    val imageHref : String
)

