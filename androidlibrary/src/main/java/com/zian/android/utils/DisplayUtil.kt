package com.zian.android.utils

import android.content.Context
import android.util.TypedValue

/**
 * Just :
 * @author by Zian
 * @date on 2018/8/7.
 */
class DisplayUtil {

    companion object {
        fun dipToPx(context: Context, dip: Float): Float {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, context.resources.displayMetrics)
        }
    }
}