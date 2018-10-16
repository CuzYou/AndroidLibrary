package com.zian.android.utils

import com.zian.android.view.LoadingLayout

/**
 * Just : 网络请求加载页面展示隐藏工具类
 * @author by Zian
 * @date on 2018/9/28.
 */
object LoadLayoutUtil {
    fun loading(loadingLayout: LoadingLayout) {
        loadingLayout.loading()
    }

    fun loadingSuccess(loadingLayout: LoadingLayout) {
        loadingLayout.loadSuccess()
    }

    fun loadingEmpty(loadingLayout: LoadingLayout) {
        loadingLayout.loadNoData()
    }

    fun loadingError(loadingLayout: LoadingLayout) {
        loadingLayout.loadError()
    }
}