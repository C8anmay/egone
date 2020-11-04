package com.acm.drawer.alladapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acm.drawer.R
import com.acm.drawer.playingmodel.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.popular_item.view.*

class PlayingAdapter(var playingList: List<Result> = ArrayList<Result>()) :
    RecyclerView.Adapter<PlayingAdapter.PlayingViewHolder>() {
    var mClickListener: PlayingAdapter.ClickListener? = null
    fun setOnClickListener(clickListener: PlayingAdapter.ClickListener) {
        this.mClickListener = clickListener
    }

    inner class PlayingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        lateinit var result: Result

        init {
            itemView.setOnClickListener(this)
        }

        fun bindPlaying(result: Result) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+result.poster_path).into(itemView.item_video)
            itemView.item_Title.text=result.title
        }

        override fun onClick(view: View?) {
            mClickListener?.onClcik(result)
        }

    }

    interface ClickListener {
        fun onClcik(result: Result)

    }
    fun updatePlaying(resultList:List<Result>){
        this.playingList=resultList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayingViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.popular_item,parent,false)
        return PlayingViewHolder(view)
    }

    override fun getItemCount(): Int =playingList.size
    override fun onBindViewHolder(holder: PlayingViewHolder, position: Int) {
        holder.bindPlaying(playingList[position])    }
}