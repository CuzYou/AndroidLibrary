package com.zian.android.utils

import java.math.BigDecimal

/**
 * Just : 返回数据格式处理工具类
 * @author by Zian
 * @date on 2018/9/18.
 */
object DataUtil {

    fun subZeroAndDot(s: String): String {
        var s = s
        if (s.indexOf(".") > 0) {
            //去掉多余的0
            s = s.replace("0+?$".toRegex(), "")
            //如最后一位是.则去掉
            s = s.replace("[.]$".toRegex(), "")
        }
        return s
    }

    fun bigDecimalToString(number: BigDecimal?): String {
        return if (number == null) {
            "0"
        } else {
            subZeroAndDot(number.toPlainString())
        }
    }

    fun stringToBigDecimal(strNumber: String?): BigDecimal {
        return if (MatchUtil.isEmpty(strNumber)) {
            BigDecimal("0")
        } else {
            BigDecimal(strNumber)
        }
    }
}