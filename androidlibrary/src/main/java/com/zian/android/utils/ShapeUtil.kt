package com.zian.android.utils

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat

/**
 * Just :
 * @author by Zian
 * @date on 2018/8/7.
 */
class ShapeUtil {

    companion object {
        fun drawViewShape(context: Context, roundRadius: Float, strokeWidth: Float,
                            fillColorId: Int, strokeColorId: Int): GradientDrawable {
            var strokeColor = 0
            if (strokeColorId > 0) {
                strokeColor = ContextCompat.getColor(context, strokeColorId)
            }
            val gd = GradientDrawable()
            if (fillColorId > 0) {
                gd.setColor(ContextCompat.getColor(context, fillColorId))
            }
            gd.cornerRadius = DisplayUtil.dipToPx(context, roundRadius)
            if (strokeWidth > 0 && strokeColor != 0) {
                gd.setStroke((DisplayUtil.dipToPx(context, strokeWidth)).toInt(), strokeColor)
            }
            return gd
        }
    }
}