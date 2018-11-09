package com.zian.androidlibrary.base

import android.app.Application
import com.zian.android.base.LibInit
import com.zian.androidlibrary.R

class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        LibInit.newBuilder().setTitleBarColor(R.color.colorPrimary, R.color.white)
    }
}