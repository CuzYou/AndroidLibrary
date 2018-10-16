package com.zian.android.view

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger
import com.aspsine.swipetoloadlayout.SwipeTrigger

/**
 * Just :
 * @author by Zian
 * @date on 2018/9/18.
 */
class RefreshHeaderView : AppCompatTextView, SwipeRefreshTrigger, SwipeTrigger {
    override fun onReset() {
        text = ""
    }

    override fun onComplete() {
        text = "COMPLETE"
    }

    override fun onRelease() {
    }

    override fun onMove(yScrolled: Int, isComplete: Boolean, automatic: Boolean) {
        if (!isComplete) {
            if (yScrolled >= height) {
                text = "RELEASE TO REFRESH"
            } else {
                text = "SWIPE TO REFRESH"
            }
        } else {
            text = "REFRESH RETURNING"
        }
    }

    override fun onPrepare() {
        text = ""
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onRefresh() {
        text = "REFRESHING"
    }

}