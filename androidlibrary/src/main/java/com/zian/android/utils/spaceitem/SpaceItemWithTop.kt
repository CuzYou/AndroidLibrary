package com.zian.android.utils.spaceitem

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Just :
 * @author by Zian
 * @date on 2018/9/20.
 */
class SpaceItemWithTop(val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = space
        }
        outRect.bottom = space
    }
}