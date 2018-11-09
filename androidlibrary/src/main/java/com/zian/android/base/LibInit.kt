package com.zian.android.base

import android.content.Context
import android.support.annotation.ColorInt
import android.support.v4.content.ContextCompat
import com.zian.android.R
import com.zian.android.config.ConstConfig

class LibInit {

    companion object {

        private lateinit var mLibInit: LibInit

        fun newBuilder(): LibInit {
            mLibInit = LibInit()
            return mLibInit
        }

        fun newBuilder(context: Context): LibInit {
            mLibInit = LibInit()
            return mLibInit
        }
    }

    /**
     * 添加Retrofit请求的ip地址及成功的code 如 http://12.34.56.789:80/
     */
    fun setRequestBaseUrl(url: String): LibInit {
        ConstConfig.BASE_URL = url
        return this
    }

    /**
     * 请求成功返回状态码
     */
    fun setRequestSuccessCode(successCode: Int): LibInit {
        ConstConfig.CODE_SUCCESS = successCode
        return this
    }

    /**
     * 网络请求超时
     */
    fun setRequestTimeout(time: Long): LibInit {
        ConstConfig.REQUEST_TIMEOUT = time
        return this
    }

    /**
     * 网络请求返回码的参数名
     */
    fun setCodeName(codeName: String): LibInit {
        ConstConfig.CODE_NAME = codeName
        return this
    }

    /**
     * release 或者 debug 使用如:错误日志
     */
    fun setIsDebug(isDebug: Boolean): LibInit {
        ConstConfig.IS_DEBUG = isDebug
        return this
    }

    /**
     * 标题栏背景 字体颜色
     */
    fun setTitleBarColor(bgColor: Int, fontColor: Int): LibInit {
        ConstConfig.TITLEBAR_BG_COLOR = bgColor
        ConstConfig.TITLEBAR_FONT_COLOR = fontColor
        return this
    }

}