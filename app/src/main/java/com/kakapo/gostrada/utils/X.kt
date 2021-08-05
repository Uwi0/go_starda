package com.kakapo.gostrada.utils

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object Constants {

}

@Suppress("DEPRECATION")
private fun getIsConnected(connectivityManager: ConnectivityManager): Boolean {
    var isConnected = false

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val networkCapabilities = connectivityManager.activeNetwork ?: null
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: null

        isConnected = if (actNw != null){
            when{
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }else false
    }else{
        connectivityManager.run {
            connectivityManager.activeNetworkInfo?.run {
                isConnected = when(type){
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
    }

    return isConnected
}

enum class NetworkState{
    CONNECTED,
    DISCONNECTED
}