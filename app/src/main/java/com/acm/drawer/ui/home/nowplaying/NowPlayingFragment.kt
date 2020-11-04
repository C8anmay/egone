package com.acm.drawer.ui.home.nowplaying

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.acm.drawer.R
import com.acm.drawer.alladapter.PlayingAdapter
import com.acm.drawer.playingmodel.Result
import kotlinx.android.synthetic.main.fragment_now_playing.*
class NowPlayingFragment : Fragment(), PlayingAdapter.ClickListener {
    private lateinit var nowplayingmodel: NowPlayingViewModel
    private lateinit var playingAdapter: PlayingAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_now_playing, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nowplayingmodel = ViewModelProvider(this).get(NowPlayingViewModel::class.java)
        playingAdapter = PlayingAdapter()
        playing_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = playingAdapter
        }
        playingAdapter.setOnClickListener(this)
        oberveViewModel()
    }
    private fun oberveViewModel(){
        nowplayingmodel.getResult().observe(viewLifecycleOwner, Observer {
            playingAdapter.updatePlaying(it.results) })
    }

    override fun onResume() {
        super.onResume()
        nowplayingmodel.loadResult()
    }

    override fun onClcik(result: Result) {
        Toast.makeText(context, "Playing", Toast.LENGTH_LONG).show()
    }


}