package com.newsapp.shared.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class ConnectionDetector(val context: Context) {

    fun isOnline(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val isOnline = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.getNetworkCapabilities(cm.activeNetwork)
                ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else cm?.activeNetworkInfo?.isConnected
        return isOnline ?: false
    }
}