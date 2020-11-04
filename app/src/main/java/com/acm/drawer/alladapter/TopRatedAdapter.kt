package com.acm.drawer.alladapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acm.drawer.R
import com.acm.drawer.topratemodel.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.popular_item.view.*

class TopRatedAdapter (var topList: List<Result> = ArrayList<Result>()):
RecyclerView.Adapter<TopRatedAdapter.TopRatedViewHolder>(){
    var mClickListener:ClickListener? = null
    fun setOnClickListener(clickListener:ClickListener){
        this.mClickListener=clickListener
    }


    inner class TopRatedViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        lateinit var result:Result
        init {
            itemView.setOnClickListener(this)
        }
        fun bindTopRate(result: Result){
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+result.poster_path).into(itemView.item_video)
            itemView.item_Title.text = result.title
        }
        override fun onClick(view: View?) {
            mClickListener?.onClick(result)
        }

    }
    fun updateTopRate(resultList:List<Result>){
        this.topList=resultList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.popular_item,parent,false)
        return TopRatedViewHolder(view)
    }

    override fun getItemCount(): Int =topList.size

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        holder.bindTopRate(topList[position])
    }
    interface ClickListener{
        fun onClick(result: Result)
    }
}