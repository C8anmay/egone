package com.acm.drawer.ui.home.popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.drawer.api.ApiClient
import com.acm.drawer.popularmodel.Popular
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularViewModel :ViewModel(){
    private var result:MutableLiveData<Popular> = MutableLiveData()
    fun getResult(): LiveData<Popular> = result
    fun loadResult(){
        var popularApiClient = ApiClient()
        val call = popularApiClient.getTopHeadlines()

        call.enqueue(object: Callback<Popular> {
            override fun onFailure(call: Call<Popular>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }

            override fun onResponse(call: Call<Popular>, response: Response<Popular>) {
                Log.d("Error>>>>",response.body().toString())
                result.value = response.body()
            }

       })
    }


}


