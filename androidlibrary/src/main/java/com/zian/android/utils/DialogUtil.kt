package com.zian.android.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.util.DisplayMetrics
import android.view.WindowManager
import com.zian.android.R

/**
 * Just : 对话框工具类
 * @author by Zian
 * @date on 2018/10/9.
 */
object DialogUtil {

    fun showAlertDialog(
        context: Context, title: String, message: String, positiveStr: String, negativeStr: String,
        positiveCallBack: DialogInterface.OnClickListener, negativeCallBack: DialogInterface.OnClickListener
    ) {
        showAlertDialog(context, title, message, positiveStr, negativeStr, true, positiveCallBack, negativeCallBack)
    }

    fun showAlertDialog(
        context: Context,
        title: String,
        message: String,
        positiveStr: String,
        negativeStr: String,
        isCancelable: Boolean,
        positiveCallBack: DialogInterface.OnClickListener,
        negativeCallBack: DialogInterface.OnClickListener
    ) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveStr, positiveCallBack)
            .setNegativeButton(negativeStr, negativeCallBack)
        builder.setCancelable(isCancelable)
        builder.show()
    }

    fun showAlertDialog(
        context: Context, title: String, message: String, positiveStr: String,
        positiveCallBack: DialogInterface.OnClickListener
    ) {
        showAlertDialog(context, title, message, positiveStr, false, positiveCallBack)
    }

    fun showAlertDialog(
        context: Context, title: String, message: String, positiveStr: String, isCancelable: Boolean,
        positiveCallBack: DialogInterface.OnClickListener
    ) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveStr, positiveCallBack)
        builder.setCancelable(isCancelable)
        builder.show()
    }

    fun showNoiceAlertDialog(context: Context, title: String, message: String, positiveStr: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveStr) { dialog, which -> dialog.dismiss() }
        builder.setCancelable(false)
        builder.show()
    }


    fun showDialog(activity: Activity?, viewId: Int, gravity: Int): Dialog {

        val mDialog = Dialog(activity!!, R.style.dialog_style)
        mDialog.setContentView(viewId)
        val windowManager = activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val dialogWindow = mDialog.window
        val lp = dialogWindow?.attributes
        lp?.width = dm.widthPixels
        dialogWindow?.attributes = lp
        dialogWindow?.setGravity(gravity)
        mDialog.setCancelable(false)
        mDialog.setCanceledOnTouchOutside(true)
        mDialog.show()
        return mDialog

    }

}