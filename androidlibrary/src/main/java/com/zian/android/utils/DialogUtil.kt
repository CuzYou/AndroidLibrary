package com.zian.android.utils

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog

/**
 * Just : 对话框工具类
 * @author by Zian
 * @date on 2018/10/9.
 */
object DialogUtil {

    fun showAlertDialog(context: Context, title: String, message: String, positiveStr: String, negativeStr: String,
                        positiveCallBack: DialogInterface.OnClickListener,negativeCallBack: DialogInterface.OnClickListener) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveStr,positiveCallBack)
                .setNegativeButton(negativeStr,negativeCallBack)
    }
}