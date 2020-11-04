package com.acm.drawer.ui.home.toprate

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.drawer.api.ApiClient
import com.acm.drawer.topratemodel.Top_Rate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRateViewModel : ViewModel() {
    private var result: MutableLiveData<Top_Rate> = MutableLiveData()
    fun getResult(): LiveData<Top_Rate> = result

    fun loadResult() {
        var topRateApiClient = ApiClient()
        val call = topRateApiClient.getTopRate()
        call.enqueue(object : Callback<Top_Rate> {
            override fun onFailure(call: Call<Top_Rate>, t: Throwable) {
                Log.d("Error>>>>", t.toString())
            }

            override fun onResponse(call: Call<Top_Rate>, response: Response<Top_Rate>) {
                Log.d("Error>>>>", response.body().toString())
                result.value = response.body()

            }

        })
    }

}