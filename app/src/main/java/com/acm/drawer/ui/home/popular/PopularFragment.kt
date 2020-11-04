package com.acm.drawer.ui.home.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.acm.drawer.R
import com.acm.drawer.alladapter.PopularAdapter
import com.acm.drawer.popularmodel.Result
import kotlinx.android.synthetic.main.fragment_popular.*


class PopularFragment : Fragment(), PopularAdapter.ClickListener {
    lateinit var popularViewModel: PopularViewModel
    lateinit var popularAdapter: PopularAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popular, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popularViewModel = ViewModelProvider(this).get(PopularViewModel::class.java)
        popularAdapter = PopularAdapter()
        popular_recycler.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = popularAdapter

        }
        observeViewmodel()
    }

    private fun observeViewmodel() {
        popularViewModel.getResult().observe(
            viewLifecycleOwner, Observer {
                popularAdapter.updatePopular(it.results)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        popularViewModel.loadResult()
    }

    override fun onClcik(result: Result) {
        Toast.makeText(context,"Popular",Toast.LENGTH_LONG).show()
    }


}


