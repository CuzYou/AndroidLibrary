package com.zian.android.utils

import android.graphics.Color
import android.support.design.widget.Snackbar
import android.view.View

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
object SnackBarUtil {

    private var snackbar: Snackbar? = null

    fun short(view: View, hint: String?) {
        hint?.let {
            if (snackbar == null) {
                //val layout = LayoutInflater.from(context).inflate(R.layout.layout_toast_view, null)
                snackbar = Snackbar.make(view, it, Snackbar.LENGTH_SHORT)
                        .setAction("Done") {
                            snackbar!!.dismiss()
                        }.setActionTextColor(Color.parseColor("#11D8C3"))

                snackbar!!.view.setBackgroundColor(Color.parseColor("#A0000000"))
            } else {
                snackbar?.setText(it)
                snackbar?.duration = Snackbar.LENGTH_SHORT
            }
            snackbar?.show()
        }
    }

    fun short(view: View, resId: Int?) {
        resId?.let {
            if (snackbar == null) {
                snackbar = Snackbar.make(view, it, Snackbar.LENGTH_SHORT)
                        .setAction("Done") {
                            snackbar!!.dismiss()
                        }.setActionTextColor(Color.parseColor("#11D8C3"))

                snackbar!!.view.setBackgroundColor(Color.parseColor("#A0000000"))
            } else {
                snackbar?.setText(it)
                snackbar?.duration = Snackbar.LENGTH_SHORT
            }
            snackbar?.show()
        }
    }

    fun long(view: View, hint: String?) {
        hint?.let {
            if (snackbar == null) {
                snackbar = Snackbar.make(view, it, Snackbar.LENGTH_LONG)
                        .setAction("Done") {
                            snackbar!!.dismiss()
                        }.setActionTextColor(Color.parseColor("#11D8C3"))

                snackbar!!.view.setBackgroundColor(Color.parseColor("#A0000000"))
            } else {
                snackbar?.setText(it)
                snackbar?.duration = Snackbar.LENGTH_LONG
            }
            snackbar?.show()
        }
    }

    fun long(view: View, resId: Int?) {
        resId?.let {
            if (snackbar == null) {
                snackbar = Snackbar.make(view, it, Snackbar.LENGTH_LONG)
                        .setAction("Done") {
                            snackbar!!.dismiss()
                        }.setActionTextColor(Color.parseColor("#11D8C3"))

                snackbar!!.view.setBackgroundColor(Color.parseColor("#A0000000"))
            } else {
                snackbar?.setText(it)
                snackbar?.duration = Snackbar.LENGTH_LONG
            }
            snackbar?.show()
        }
    }
}