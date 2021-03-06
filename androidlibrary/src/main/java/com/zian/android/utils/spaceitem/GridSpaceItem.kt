package com.zian.android.utils.spaceitem

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Just :
 * @author by Zian
 * @date on 2018/10/9.
 */
class GridSpaceItem(val spanCount: Int, val spacing: Int, val includeEdge: Boolean) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount
            outRect.right = (column + 1) * spacing / spanCount

            if (position < spanCount) {
                outRect.top = spacing
            }
            outRect.bottom = spacing
        } else {
            outRect.left = column * spacing / spanCount
            outRect.right = spacing - (column + 1) * spacing / spanCount
            if (position >= spanCount) {
                outRect.top = spacing
            }
        }
    }
}