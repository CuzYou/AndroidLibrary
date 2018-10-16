package com.zian.android.utils

import android.text.TextUtils
import android.widget.EditText
import java.util.regex.Pattern

/**
 * Just : 字段匹配工具类
 * @author by Zian
 * @date on 2018/8/7.
 */
class MatchUtil {

    companion object {

        fun isCommonMatcher(reg: String, matchContent: String): Boolean {
            val p = Pattern.compile(reg)
            val m = p.matcher(matchContent)
            return m.matches()
        }

        fun isPhoneNumber(phoneNumber: String): Boolean {
            val phoneReg = "1\\d{10}$"
            return isCommonMatcher(phoneReg, phoneNumber)
        }

        fun isEmail(email: String): Boolean {
            val emailReg = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"
            return isCommonMatcher(emailReg, email)
        }

        fun isEmpty(vararg strs: String?): Boolean {
            strs.forEach {
                if (TextUtils.isEmpty(it)) return true
            }
            return false
        }

        //判断编辑框是否为空
        fun isEditTextEmpty(vararg editTexts: EditText): Boolean {
            editTexts.forEach {
                if (isEmpty(it.text.toString())) return true
            }
            return false
        }

        //判断是否是手机号或者邮箱
        fun isPhoneAndEmail(account:String): Boolean {
            if (MatchUtil.isPhoneNumber(account) || MatchUtil.isEmail(account)) {
                return true
            }
            return false
        }


        fun <T1, T2> ifNotNull(value1: T1?, value2: T2?, bothNotNull: (T1, T2) -> (Unit)) {
            if (value1 != null && value2 != null) {
                bothNotNull(value1, value2)
            }
        }
    }
}