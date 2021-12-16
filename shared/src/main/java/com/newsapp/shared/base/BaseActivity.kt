package com.newsapp.shared.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity : AppCompatActivity() {


    /**
     *  provide binding for the child activity
     */
    protected inline fun <reified T : ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> =
        lazy {
            DataBindingUtil.setContentView<T>(this, resId).apply {
                lifecycleOwner = this@BaseActivity
            }
        }

}