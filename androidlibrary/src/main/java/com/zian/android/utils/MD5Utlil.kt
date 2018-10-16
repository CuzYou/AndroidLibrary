package com.zian.android.utils

import java.security.MessageDigest

/**
 * Just :
 * @author by Zian
 * @date on 2018/8/6.
 */
class MD5Utlil {
    companion object {
        fun encode(text: String): String {
            try {
                //获取md5加密对象
                val instance: MessageDigest = MessageDigest.getInstance("MD5")
                //对字符串加密，返回字节数组
                val digest: ByteArray = instance.digest(text.toByteArray())
                var sb = StringBuffer()
                for (b in digest) {
                    //获取低八位有效值
                    var i: Int = b.toInt() and 0xff
                    //将整数转化为16进制
                    var hexString = Integer.toHexString(i)
                    if (hexString.length < 2) {
                        //如果是一位的话，补0
                        hexString = "0$hexString"
                    }
                    sb.append(hexString)
                }
                return sb.toString()

            } catch (e: Throwable) {
                e.printStackTrace()
            }

            return ""
        }
    }
}