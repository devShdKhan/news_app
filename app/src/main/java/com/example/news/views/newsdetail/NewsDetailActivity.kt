package com.example.news.views.newsdetail

import android.os.Bundle
import com.example.news.R
import com.example.news.databinding.ActivityNewsDetailBinding
import com.newsapp.shared.base.BaseActivity
import com.newsapp.shared.constant.BaseConstants
import com.newsapp.shared.models.NewsModel
import com.newsapp.shared.utils.Navigator.openExternalBrowser
import dagger.hilt.android.AndroidEntryPoint

/**
 *  Not using ViewModel here because we don't have any extra work here.
 */
@AndroidEntryPoint
class NewsDetailActivity : BaseActivity() {

    private val mBinding by binding<ActivityNewsDetailBinding>(R.layout.activity_news_detail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = intent.getSerializableExtra(BaseConstants.INTENT_PASS_NEWS) as NewsModel
        mBinding.apply {
            lifecycleOwner = this@NewsDetailActivity
            newsModel = model
            executePendingBindings()
            icBack.setOnClickListener { onBackPressed() }
            btnReadMore.setOnClickListener { openExternalBrowser(model.url) }
        }
    }
}