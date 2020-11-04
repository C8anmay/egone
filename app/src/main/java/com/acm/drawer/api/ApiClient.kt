package com.acm.drawer.api

import com.acm.drawer.Utube.Utube
import com.acm.drawer.playingmodel.Playing
import com.acm.drawer.popularmodel.Popular
import com.acm.drawer.topratemodel.Top_Rate
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "https://api.themoviedb.org/3/movie/"

    companion object {
        val API_KEY = "332d3e0883ab4ca111301b182654fae4"
    }

    private val apiInterface: ApiInterface

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getTopHeadlines(
    ): Call<Popular> {
        return apiInterface.getTopHeadlines(API_KEY)
    }
    fun getTopPlaying():Call<Playing>{
        return apiInterface.getTopPlaying(API_KEY)
    }
    fun getTopRate():Call<Top_Rate>{
        return apiInterface.getTopRate(API_KEY)
    }
//    fun getTopUtube(id:String):Call<Utube>{
//        return apiInterface.getUtube(id, API_KEY)
//    }


}