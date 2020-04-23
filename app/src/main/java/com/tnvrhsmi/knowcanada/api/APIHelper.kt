package com.tnvrhsmi.knowcanada.api

import com.tnvrhsmi.knowcanada.data.model.FactModel
import retrofit2.Call
import retrofit2.http.GET

interface APIHelper {
    @GET(APIConstants.FACTS)
    fun facts(): Call<FactModel>
}