package com.acm.drawer.ui.home.nowplaying
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.drawer.api.ApiClient
import com.acm.drawer.playingmodel.Playing
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NowPlayingViewModel :ViewModel(){
    private var result: MutableLiveData<Playing> = MutableLiveData()
    fun getResult(): LiveData<Playing> = result
    fun loadResult(){
        var playingapiClient= ApiClient()
        var call=playingapiClient.getTopPlaying()
       call.enqueue(object : Callback<Playing>{
           override fun onFailure(call: Call<Playing>, t: Throwable) {
               Log.d("Error>>",t.toString())
           }

           override fun onResponse(call: Call<Playing>, response: Response<Playing>) {
               Log.d("Error>>>",response.body().toString())
               result.value= response.body()
           }
       } )
    }
}