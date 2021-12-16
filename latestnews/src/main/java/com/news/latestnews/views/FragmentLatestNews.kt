package com.news.latestnews.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.news.latestnews.R
import com.news.latestnews.adapters.AdapterLatestNews
import com.news.latestnews.databinding.FragmentLatestNewsBinding
import com.news.latestnews.viewmodels.LatestNewsViewModel
import com.newsapp.shared.base.BaseFragment
import com.newsapp.shared.listeners.NewsItemClickListener
import com.newsapp.shared.models.NewsModel
import com.newsapp.shared.models.Response
import com.newsapp.shared.utils.Navigator.openNewsDetail
import com.newsapp.shared.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLatestNews : BaseFragment<FragmentLatestNewsBinding>(), NewsItemClickListener {

    companion object {
        fun getInstance() = FragmentLatestNews()
    }

    override val layoutId = R.layout.fragment_latest_news
    val mViewModel by viewModels<LatestNewsViewModel>()
    lateinit var adapterLatestNews: AdapterLatestNews

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
                    adapterLatestNews.updateList(it.data ?: listOf())
                }
            }
        }
    }

    /**
     *   setting up recyclerview here
     */
    private fun setupRecyclerView() {
        adapterLatestNews = AdapterLatestNews(this)
        mBinding.rvNews.adapter = adapterLatestNews
    }

    /**
     *  onNewsClick will call when user click on any news
     */
    override fun onNewsClick(news: NewsModel) {
        openNewsDetail(news)
    }

}