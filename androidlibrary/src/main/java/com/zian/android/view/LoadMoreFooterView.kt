package com.zian.android.view

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import com.aspsine.swipetoloadlayout.SwipeLoadMoreTrigger
import com.aspsine.swipetoloadlayout.SwipeTrigger

/**
 * Just :
 * @author by Zian
 * @date on 2018/9/18.
 */
class LoadMoreFooterView : AppCompatTextView, SwipeLoadMoreTrigger, SwipeTrigger {
    override fun onLoadMore() {
        text = "LOADING MORE"
    }

    override fun onReset() {
        text = ""
    }

    override fun onComplete() {
        text = "COMPLETE"
    }

    override fun onRelease() {
        text = "LOADING MORE"
    }

    override fun onMove(yScrolled: Int, isComplete: Boolean, automatic: Boolean) {
        if (!isComplete) {
            if (yScrolled <= -height) {
                text = "RELEASE TO LOAD MORE"
            } else {
                text = "SWIPE TO LOAD MORE"
            }
        } else {
            text = "LOAD MORE RETURNING"
        }
    }

    override fun onPrepare() {
        text = ""
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
}