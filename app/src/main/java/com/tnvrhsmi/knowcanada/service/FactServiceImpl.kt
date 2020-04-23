package com.tnvrhsmi.knowcanada.service

import android.util.Log
import com.tnvrhsmi.knowcanada.api.APIConstants
import com.tnvrhsmi.knowcanada.api.APIHelper
import com.tnvrhsmi.knowcanada.api.Fact
import com.tnvrhsmi.knowcanada.data.model.DataFetchListener
import com.tnvrhsmi.knowcanada.data.model.FactModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class FactServiceImpl : FactService {

    private var apiHelper: APIHelper

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(APIConstants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        apiHelper = retrofit.create(APIHelper::class.java)
    }

    override fun getFacts(dataFetchListener: DataFetchListener ) {

        var apiCallBack = apiHelper.facts()

        apiCallBack.enqueue(object : Callback<FactModel> {
            override fun onResponse(
                call: Call<FactModel>,
                response: Response<FactModel>
            ) {
                Log.i("Response", response.body().toString())
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString())
                        dataFetchListener?.onDataFetchSuccess(response.body() as FactModel)
                    }
                    else {
                        Log.i(
                            "onEmptyResponse",
                            "Returned empty response"
                        )
                        // Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            override fun onFailure(call: Call<FactModel>, t: Throwable) {
                dataFetchListener?.onDataFetchError("Something went wrong")
            }
        })
    }
}