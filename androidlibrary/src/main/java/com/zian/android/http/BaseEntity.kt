package com.zian.android.http

import com.zian.android.config.ConstConfig

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
open class BaseEntity<T> {
    var code: Int? = null
    var message: String? = null
    var data: T? = null

    fun isSuccess(): Boolean {
        return code == ConstConfig.CODE_SUCCESS
    }
}