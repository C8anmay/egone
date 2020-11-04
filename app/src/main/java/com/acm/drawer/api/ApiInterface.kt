package com.acm.drawer.api
import com.acm.drawer.playingmodel.Playing
import com.acm.drawer.popularmodel.Popular
import com.acm.drawer.topratemodel.Top_Rate
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("popular")
    fun getTopHeadlines(
        @Query("api_key") api_key: String
    ): Call<Popular>

    @GET("now_playing")
    fun getTopPlaying(
        @Query("api_key")api_key: String
        ):Call<Playing>

    @GET("top_rated")
    fun getTopRate(
        @Query("api_key")api_key: String
    ):Call<Top_Rate>

    @GET("{movies_id}")
    fun getUtube(
        @Query("movie_id")movie_id: String,
        @Query("api_key")api_key:String
    )


}