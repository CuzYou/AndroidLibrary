package com.zian.android.utils

import android.app.Activity
import com.tbruyelle.rxpermissions2.RxPermissions

/**
 * Just : 权限请求
 * @author by Zian
 * @date on 2018/7/26.
 */
class PermissionManager {
    private var permission = ""

    companion object {

        private lateinit var mPermissionManager: PermissionManager
        private lateinit var rxPermissions: RxPermissions

        fun newBuilder(activity: Activity): PermissionManager {
            mPermissionManager = PermissionManager()
            rxPermissions = RxPermissions(activity)
            return mPermissionManager
        }
    }

    fun setPermission(permission: String): PermissionManager {
        this.permission = permission
        return this
    }

    fun callBack(callBack: PermissionRequestCallBack) {
        rxPermissions.request(permission)
                .subscribe({
                    if (it) {
                        callBack.successCallBack()
                        // CaptureActivity.intentCaptureActivityForResult(this)
                    } else {
                        //DialogUtils.showGetPermissionDialog(this)
                        callBack.failureCallBack()
                    }
                }, { t -> t.printStackTrace() })
    }

    interface PermissionRequestCallBack {
        fun successCallBack()

        fun failureCallBack()
    }
}