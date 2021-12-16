package com.newsapp.shared.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<VH : RecyclerView.ViewHolder, M : Any> :
    RecyclerView.Adapter<VH>() {

    var mItemsList: List<M> = emptyList()


    /**
     *   Updating the itemlist here and call @notifyDataSetChanged() for the refresh list
     */
    fun updateList(list: List<M>) {
        mItemsList = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = mItemsList.size

}