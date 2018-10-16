package com.zian.android.view

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.zian.android.R

/**
 * Just : 
 * @author by Zian
 * @date on 2018/8/3.
 */
class Titlebar : LinearLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    private var llTitleBar: LinearLayout? = null
    private var llLeft: LinearLayout? = null
    private var ivLeft: ImageView? = null
    private var tvLeft: TextView? = null
    private var tvRight: TextView? = null
    private var llTitle: LinearLayout? = null
    private var tvTitle: TextView? = null
    private var ivTitleRight: ImageView? = null

    init {
        initView()
    }

    fun initView() {
        val titleView = LayoutInflater.from(context).inflate(R.layout.layout_title_bar, this)
        llTitleBar = titleView.findViewById(R.id.ll_title_bar)
        val paddingTop = llTitleBar!!.paddingTop + getStatusBarHeight()
        llTitleBar?.setPadding(llTitleBar!!.paddingLeft, paddingTop, llTitleBar!!.paddingRight, llTitleBar!!.paddingBottom)

        llLeft = titleView.findViewById(R.id.ll_left)
        ivLeft = titleView.findViewById(R.id.iv_left)
        tvLeft = titleView.findViewById(R.id.tv_left)
        tvRight = titleView.findViewById(R.id.tv_right)
        llTitle = titleView.findViewById(R.id.ll_title)
        tvTitle = titleView.findViewById(R.id.tv_title)
        ivTitleRight = titleView.findViewById(R.id.iv_title_right)
    }

    fun setLeftLayoutVisibility(visibility: Int) {
        llLeft?.visibility = visibility
    }

    fun setLeftTextVisibility(visibility: Int) {
        tvLeft?.visibility = visibility
    }

    fun setRightLayoutVisibility(visibility: Int) {
        tvRight?.visibility = visibility
    }

    fun setTitleLayoutVisibility(visibility: Int) {
        llTitle?.visibility = visibility
    }

    fun setLeftText(leftText: String) {
        tvLeft?.text = leftText
    }

    fun setRightText(rightText: String) {
        tvRight?.text = rightText
    }

    fun setTitle(titleText: Int) {
        tvTitle?.setText(titleText)
    }

    fun setTitle(titleText: String) {
        tvTitle?.text = titleText
    }

    fun getLeftImageView(): ImageView {
        return ivLeft!!
    }

    fun setLeftLayoutClickListener(listener: OnClickListener) {
        llLeft?.setOnClickListener(listener)
    }

    fun setTitleLayoutClickListener(listener: OnClickListener) {
        llTitle?.setOnClickListener(listener)
    }

    fun setRightLayoutClickListener(listener: OnClickListener) {
        tvRight?.setOnClickListener(listener)
    }

    fun setTitleBarColor(colorTitleBar: Int, colorTitle: Int, colorTitleText: Int) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            llTitleBar?.setBackgroundColor(colorTitleBar)
        } else {
            llTitleBar?.setBackgroundColor(Color.parseColor("#11D8C3"))
        }
        llTitle?.setBackgroundColor(colorTitle)
        tvTitle?.setTextColor(colorTitleText)
    }


    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

}