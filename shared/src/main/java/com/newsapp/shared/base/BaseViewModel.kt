package com.newsapp.shared.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

/**
 *  isLoading for progress visibility
 *  isListEmpty for the no item data visibility
 */

open class BaseViewModel : ViewModel() {

    val isLoading = ObservableBoolean(false)
    val isListEmpty = ObservableBoolean(false)
}