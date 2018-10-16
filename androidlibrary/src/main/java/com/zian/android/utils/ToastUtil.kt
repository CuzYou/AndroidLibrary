package com.zian.android.utils

import android.content.Context
import android.widget.Toast

/**
 * Just : 吐司
 * @author by Zian
 * @date on 2018/7/26.
 */
object ToastUtil {
    private var toast: Toast? = null

    fun short(context: Context, hint: String) {
        if (toast == null) {
            //val layout = LayoutInflater.from(context).inflate(R.layout.layout_toast_view, null)
            toast = Toast.makeText(context, hint, Toast.LENGTH_SHORT)
        } else {
            toast?.setText(hint)
            toast?.duration = Toast.LENGTH_SHORT
        }
        toast?.show()
    }

    fun short(context: Context, retId: Int) {
        if (toast == null) {
            toast = Toast.makeText(context, retId, Toast.LENGTH_SHORT)
        } else {
            toast?.setText(retId)
            toast?.duration = Toast.LENGTH_SHORT
        }
        toast?.show()
    }

    fun long(context: Context, hint: String) {
        if (toast == null) {
            toast = Toast.makeText(context, hint, Toast.LENGTH_LONG)
        } else {
            toast?.setText(hint)
            toast?.duration = Toast.LENGTH_LONG
        }
        toast?.show()
    }

    fun long(context: Context, retId: Int) {
        if (toast == null) {
            toast = Toast.makeText(context, retId, Toast.LENGTH_LONG)
        } else {
            toast?.setText(retId)
            toast?.duration = Toast.LENGTH_LONG
        }
        toast?.show()
    }
}