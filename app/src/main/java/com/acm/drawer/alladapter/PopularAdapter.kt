package com.acm.drawer.alladapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acm.drawer.R
import com.acm.drawer.popularmodel.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.popular_item.view.*

class PopularAdapter(var popularList: List<Result> =ArrayList<Result>()):
    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    var mClickListener: ClickListener? = null
    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class PopularViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        lateinit var result:Result
         init {
             itemView.setOnClickListener(this)
         }

    fun binPopular(result: Result){
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+result.poster_path).into(itemView.item_video)
        itemView.item_Title.text=result.title

    }

        override fun onClick(view: View?) {
            mClickListener?.onClcik(result )
        }


    }
    fun updatePopular(resultList: List<Result>) {
        this.popularList = resultList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.popular_item,parent,false)
        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int =popularList.size

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.binPopular(popularList[position])
    }
    interface ClickListener {
        fun onClcik(result: Result)

    }

}