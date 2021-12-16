package com.news.latestnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.news.latestnews.databinding.ItemLatestNewsBinding
import com.newsapp.shared.base.BaseRecyclerViewAdapter
import com.newsapp.shared.base.BaseViewHolder
import com.newsapp.shared.listeners.NewsItemClickListener
import com.newsapp.shared.models.NewsModel

class AdapterLatestNews(val listener: NewsItemClickListener) :
    BaseRecyclerViewAdapter<AdapterLatestNews.ViewHolder, NewsModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemLatestNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = mItemsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class ViewHolder(private val mBinding: ItemLatestNewsBinding) :
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