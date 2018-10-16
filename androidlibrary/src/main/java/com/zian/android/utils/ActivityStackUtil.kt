package com.zian.android.utils

import android.app.Activity
import java.util.*

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
class ActivityStackUtil {

    companion object {
        private val mActivityStackUtil = Stack<Activity>()
        val instance: ActivityStackUtil by lazy { ActivityStackUtil() }
    }

    //将当前的activity推入栈中
    fun addActivity(activity: Activity) {
        mActivityStackUtil.push(activity)
    }

    //将activity销毁
    fun removeActivity(activity: Activity) {
        mActivityStackUtil.remove(activity)
    }

    //销毁所有activity
    fun removeAllActivity() {
        while (!mActivityStackUtil.isEmpty()) {
            val activity = mActivityStackUtil.pop()
            activity?.finish()
        }
    }

    //关闭指定activity
    fun finishActivity(cls: Class<*>) {
        // 使用迭代器安全删除
        val it = mActivityStackUtil.iterator()
        while (it.hasNext()) {
            val activity = it.next()
            // 清理掉已经释放的activity
            if (activity == null) {
                it.remove()
                continue
            }
            if (activity!!.javaClass == cls) {
                it.remove()
                activity!!.finish()
            }
        }
    }
}