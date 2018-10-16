package com.zian.android.view

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.zian.android.R
import com.zian.android.utils.GlideUtil

/**
 * Just :
 * @author by Zian
 * @date on 2018/8/9.
 */
class LoadingLayout : FrameLayout {

    private val LOADINGVIEW_POSITION = 0

    private var ivLoading: AppCompatImageView? = null
    private var ivNoData: AppCompatImageView? = null
    private var ivError: AppCompatImageView? = null

    private var mView: View? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        initView()
    }

    private fun initView() {
        mView = View.inflate(context, R.layout.layout_loading_view, this)
        mView?.isClickable = true
        ivLoading = mView?.findViewById(R.id.iv_loading) as AppCompatImageView
        ivNoData = mView?.findViewById(R.id.iv_no_data)
        ivError = mView?.findViewById(R.id.iv_error)

        GlideUtil.loadGifImage(context, R.mipmap.gif_loading, ivLoading)
    }

    fun loading() {
        for (i in 0 until childCount) {
            if (LOADINGVIEW_POSITION == i) {
                getChildAt(i).visibility = View.VISIBLE
                ivLoading?.visibility = View.VISIBLE
                ivNoData?.visibility = View.GONE
                ivError?.visibility = View.GONE
            } else {
                getChildAt(i).visibility = View.GONE
            }
        }
    }

    fun loadNoData() {
        for (i in 0 until childCount) {
            if (LOADINGVIEW_POSITION == i) {
                getChildAt(i).visibility = View.VISIBLE
                ivLoading?.visibility = View.GONE
                ivNoData?.visibility = View.VISIBLE
                ivError?.visibility = View.GONE
            } else {
                getChildAt(i).visibility = View.GONE
            }
        }
    }

    fun loadError() {
        for (i in 0 until childCount) {
            if (LOADINGVIEW_POSITION == i) {
                getChildAt(i).visibility = View.VISIBLE
                ivLoading?.visibility = View.GONE
                ivNoData?.visibility = View.GONE
                ivError?.visibility = View.VISIBLE
            } else {
                getChildAt(i).visibility = View.GONE
            }
        }
    }

    fun loadSuccess() {
        for (i in 0 until childCount) {
            if (LOADINGVIEW_POSITION == i) {
                getChildAt(i).visibility = View.GONE
            } else {
                getChildAt(i).visibility = View.VISIBLE
            }
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        for (i in 0 until childCount) {
            getChildAt(i).visibility = View.GONE
        }
    }

}