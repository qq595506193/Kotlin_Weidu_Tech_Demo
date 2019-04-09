package com.wd.tech.app

import android.app.Application
import android.content.Context
import com.kotlinframework.net.network.RetrofitManager
import com.wd.tech.api.BaseApi

class App : Application() {
    val context: Context? = null
    override fun onCreate() {
        super.onCreate()
        RetrofitManager.instance.init(BaseApi.BASE_URL)
    }
}
