package com.zian.android.base

import android.app.Activity
import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.PopupWindow
import com.zian.android.R

/**
 * Just : popupwindow 基类
 * @author by Zian
 * @date on 2018/9/29.
 */
abstract class BasePopupWindow(val mContext: Context) : PopupWindow(mContext) {

    val mView: View

    protected abstract val layoutId: Int

    protected abstract fun getAnimId(): Int

     var isShowShadow = true

     private val bgAlpha = 0.8f

     init {
        mView = LayoutInflater.from(mContext).inflate(layoutId, null)
        width = ViewGroup.LayoutParams.WRAP_CONTENT
        height = ViewGroup.LayoutParams.WRAP_CONTENT
        contentView = mView
        setBackgroundDrawable(mContext.resources.getDrawable(R.color.transparent))
        isFocusable = true
        animationStyle = getAnimId()
        isOutsideTouchable = true
        setBackgroundDrawable(ContextCompat.getDrawable(mContext, R.drawable.shape_transparent_bg))

    }

    private fun setWindowBackground(alpha: Float) {
        val lp = (mContext as Activity).window.attributes
        lp.alpha = alpha
        mContext.window.attributes = lp
    }

    fun getScreenWidth(): Int {
        val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.widthPixels
    }

    fun getScreenHeight(): Int {
        val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.heightPixels
    }

    override fun showAtLocation(parent: View?, gravity: Int, x: Int, y: Int) {
        addAlpha()
        super.showAtLocation(parent, gravity, x, y)
    }

    override fun showAsDropDown(anchor: View?) {
        super.showAsDropDown(anchor)
        addAlpha()
    }

    override fun showAsDropDown(anchor: View?, xoff: Int, yoff: Int) {
        addAlpha()
        super.showAsDropDown(anchor, xoff, yoff)
    }

    override fun showAsDropDown(anchor: View?, xoff: Int, yoff: Int, gravity: Int) {
        addAlpha()
        super.showAsDropDown(anchor, xoff, yoff, gravity)
    }

    override fun dismiss() {
        removeAlpha()
        super.dismiss()
    }

    private fun addAlpha() {
        if (isShowShadow) {
            setWindowBackground(bgAlpha)
        }
    }

    private fun removeAlpha() {
        if (isShowShadow) {
            setWindowBackground(1f)
        }
    }
}