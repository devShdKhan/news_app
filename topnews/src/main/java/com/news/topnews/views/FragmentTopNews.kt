package com.news.topnews.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.news.topnews.R
import com.news.topnews.adapters.AdapterTopNews
import com.news.topnews.databinding.FragmentTopNewsBinding
import com.news.topnews.viewmodels.TopNewsViewModel
import com.newsapp.shared.base.BaseFragment
import com.newsapp.shared.listeners.NewsItemClickListener
import com.newsapp.shared.models.NewsModel
import com.newsapp.shared.models.Response
import com.newsapp.shared.utils.Navigator.openNewsDetail
import com.newsapp.shared.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentTopNews : BaseFragment<FragmentTopNewsBinding>(), NewsItemClickListener {

    companion object {
        fun getInstance() = FragmentTopNews()
    }

    val mViewModel by viewModels<TopNewsViewModel>()
    override val layoutId = R.layout.fragment_top_news
    lateinit var adapterTopNews: AdapterTopNews

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.viewModel = mViewModel
        setupRecyclerView()

        mViewModel.news.observe(this) {

            when (it) {
                is Response.Loading -> mViewModel.isLoading.set(true)

                is Response.Error -> {
                    mViewModel.isLoading.set(false)
                    requireActivity().showToast(it.error)
                }
                is Response.Success -> {
                    mViewModel.isLoading.set(false)
                    mViewModel.isListEmpty.set(it.data.isNullOrEmpty())
                    adapterTopNews.updateList(it.data ?: listOf())
                }
            }

        }
    }

    /**
     *   setting up recyclerview here
     */
    private fun setupRecyclerView() {
        adapterTopNews = AdapterTopNews(this)
        mBinding.rvNews.adapter = adapterTopNews
    }

    /**
     *  onNewsClick will call when user click on any news
     */
    override fun onNewsClick(news: NewsModel) {
        openNewsDetail(news)
    }

}