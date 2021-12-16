package com.news.topnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.news.topnews.databinding.ItemTopNewsBinding
import com.newsapp.shared.base.BaseRecyclerViewAdapter
import com.newsapp.shared.base.BaseViewHolder
import com.newsapp.shared.listeners.NewsItemClickListener
import com.newsapp.shared.models.NewsModel

class AdapterTopNews(val listener: NewsItemClickListener) :
    BaseRecyclerViewAdapter<AdapterTopNews.ViewHolder, NewsModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemTopNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = mItemsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class ViewHolder(private val mBinding: ItemTopNewsBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            mItemsList[position].let { news ->
                mBinding.model = news
                mBinding.listener = listener
            }
            mBinding.executePendingBindings()
        }
    }

}