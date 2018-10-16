package com.zian.android.utils

import com.zian.android.view.dialogfragment.LoadingDialogFragment

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
class ShowLoadingUtil {

    companion object {
        fun loadingView(): LoadingDialogFragment {
            val dialogFragment = LoadingDialogFragment()
            dialogFragment.isCancelable = false
            return dialogFragment
        }
    }
}