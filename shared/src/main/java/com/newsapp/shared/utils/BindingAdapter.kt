package com.newsapp.shared.utils

import android.text.TextUtils
import android.webkit.URLUtil
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.newsapp.shared.R


@BindingAdapter("setImageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (!TextUtils.isEmpty(imageUrl) && URLUtil.isValidUrl(imageUrl))
        Glide.with(view.context).load(imageUrl).placeholder(R.drawable.placeholder).into(view)
}
