package com.zian.android.http

import com.google.gson.Gson

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
class GsonUtil private constructor() {
    
    companion object {
        fun <T> parseJson(jsonData: String, type: Class<T>): T {
            return Gson().fromJson(jsonData, type)
        }
    }
}