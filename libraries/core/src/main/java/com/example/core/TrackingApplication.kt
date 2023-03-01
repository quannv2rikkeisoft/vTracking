package com.example.core

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

open class TrackingApplication : Application() {

    init {
        this.also { instance = it }
    }

    companion object {
        private var instance: TrackingApplication? = null
        fun isNetworkConnected(): Boolean {
            val cm =
                instance?.applicationContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            return cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            } ?: false
        }
    }
}