package com.zian.android.utils

import android.text.TextUtils
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.net.URLEncoder

/**
 * Just : url utf-8编码解码
 * @author by Zian
 * @date on 2018/11/09 14
 */
class UrlCodeUtil {

    companion object {

        /**
         * utf-8编码
         */
        fun encode(str: String?): String {
            if (TextUtils.isEmpty(str)) {
                return ""
            } else {
                return try {
                    URLEncoder.encode(str, "utf-8")
                } catch (e: UnsupportedEncodingException) {
                    e.printStackTrace()
                    str + ""
                }
            }
        }

        /**
         * utf-8解码
         */
        fun decode(str: String?): String {
            if (TextUtils.isEmpty(str)) {
                return ""
            } else {
                return try {
                    URLDecoder.decode(str, "utf-8")
                } catch (e: UnsupportedEncodingException) {
                    e.printStackTrace()
                    str + ""
                }
            }
        }
    }
}