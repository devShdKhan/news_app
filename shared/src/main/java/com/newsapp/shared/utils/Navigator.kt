package com.newsapp.shared.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import android.webkit.URLUtil
import androidx.fragment.app.Fragment
import com.newsapp.shared.constant.BaseConstants
import com.newsapp.shared.models.NewsModel

object Navigator {

    const val detailActivityAddress = "com.example.news.views.newsdetail.NewsDetailActivity"

    fun Fragment.openNewsDetail(newsModel: NewsModel) {
        startActivity(
            Intent(requireActivity(), Class.forName(detailActivityAddress))
                .putExtra(BaseConstants.INTENT_PASS_NEWS, newsModel)
        )
    }

    fun Context.openExternalBrowser(url: String?) {
        if (TextUtils.isEmpty(url) || !URLUtil.isValidUrl(url)) return
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

}