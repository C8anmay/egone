package com.acm.drawer.ui.home.toprate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.acm.drawer.R
import com.acm.drawer.alladapter.TopRatedAdapter
import com.acm.drawer.topratemodel.Result
import com.acm.drawer.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_toprate.*


class ToprateFragment : Fragment(), TopRatedAdapter.ClickListener {
    lateinit var topRatedAdapter: TopRatedAdapter
    private lateinit var topRateViewModel: TopRateViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_toprate, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topRateViewModel = ViewModelProvider(this).get(TopRateViewModel::class.java)
        topRatedAdapter = TopRatedAdapter()
        topRate_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = topRatedAdapter
        }
        obserViewmodel()
    }

    private fun obserViewmodel() {
        topRateViewModel.getResult().observe(
            viewLifecycleOwner, Observer { topRatedAdapter.updateTopRate(it.results) })
    }

    override fun onResume() {
        super.onResume()

        topRateViewModel.loadResult()
    }

    override fun onClick(result: Result) {
        Toast.makeText(context, "Top_Rated", Toast.LENGTH_LONG).show()
    }


}
