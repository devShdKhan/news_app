package com.newsapp.shared.utils

import android.content.Context
import android.widget.Toast


fun Context.showToast(message: String?) {
    message?.let {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
