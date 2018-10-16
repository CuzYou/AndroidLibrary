package com.zian.android.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
object ActivityUtil {
    fun intentActivity(context: Context, activity: Class<*>) {
        intentActivity(context, activity, null)
    }

    fun intentActivity(context: Context, activity: Class<*>, bundle: Bundle? = null) {
        val intent = Intent(context, activity)
        if (bundle != null)
            intent.putExtras(bundle)
        context.startActivity(intent)
    }

    fun intentActivityForResult(context: Activity, activity: Class<*>, code: Int) {
        intentActivityForResult(context, activity, null, code)
    }

    fun intentActivityForResult(context: Activity, activity: Class<*>, bundle: Bundle? = null, code: Int) {
        val intent = Intent(context, activity)
        if (bundle != null)
            intent.putExtras(bundle)
        context.startActivityForResult(intent, code)
    }

    fun clearAllActivity() {
        ActivityStackUtil.instance.removeAllActivity()
    }

    fun clearActivity(cls: Class<*>) {
        ActivityStackUtil.instance.finishActivity(cls)
    }
}