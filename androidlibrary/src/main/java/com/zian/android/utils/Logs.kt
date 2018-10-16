package com.zian.android.utils

import android.util.Log
import com.zian.android.config.ConstConfig

/**
 * Just : log日志
 * @author by Zian
 * @date on 2018/7/26.
 */
object Logs {
    private val TAG = "TAG"

    fun i(tag: String, any: Any?) {
        if (ConstConfig.IS_DEBUG)
            Log.i(tag, any?.toString() ?: "null")
    }

    fun d(tag: String, any: Any?) {
        if (ConstConfig.IS_DEBUG)
            Log.d(tag, any?.toString() ?: "null")
    }

    fun w(tag: String, any: Any?) {
        if (ConstConfig.IS_DEBUG)
            Log.w(tag, any?.toString() ?: "null")
    }

    fun e(tag: String, any: Any?) {
        if (ConstConfig.IS_DEBUG)
            Log.e(tag, any?.toString() ?: "null")
    }

    fun i(any: Any?) {
        i(TAG, any)
    }

    fun d(any: Any?) {
        d(TAG, any)
    }

    fun w(any: Any?) {
        w(TAG, any)
    }

    fun e(any: Any?) {
        e(TAG, any)
    }
}