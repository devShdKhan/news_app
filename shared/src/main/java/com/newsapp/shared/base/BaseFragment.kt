package com.newsapp.shared.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    protected lateinit var mBinding: B
    protected abstract val layoutId: Int



    /**
     *   Provide Binding for the child fragments.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }

}