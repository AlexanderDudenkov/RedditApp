package com.dudencov.redditapp.presentation.view.adapters

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dudencov.redditapp.R
import com.dudencov.redditapp.util.inflate
import com.dudencov.redditapp.util.loadImage
import kotlinx.android.synthetic.main.item_top_list.view.*

class MainAdapter(
    diffCallback: DiffUtil.ItemCallback<TopListUiModel>,
    private val itemClickListener: ((pos: Int) -> Unit)? = null
) :
    PagedListAdapter<TopListUiModel, MainViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(parent.inflate(R.layout.item_top_list)!!)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.setOnClickListener { itemClickListener?.invoke(position) }
        holder.bind(getItem(position))
    }
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(model: TopListUiModel?) {
        model?.run {
            itemView.tv_rating.text = currentRating
            itemView.tv_subreddit.text = subreddit
            itemView.tv_author.text = author
            itemView.tv_date.text = postDate
            itemView.tv_title.text = title
            itemView.iv_thumbnail.loadImage(thumbnailUrl)
            itemView.tv_comments_number.text = commentsNumber
        }
    }
}

data class TopListUiModel(
    val title: String,
    val author: String,
    val subreddit: String,
    val postDate: String,
    val thumbnailUrl: String,
    val currentRating: String,
    val commentsNumber: String,
    val detailUrl:String
)