package com.zian.android.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatDialogFragment
import android.view.*

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
abstract class BaseDialogFragment : AppCompatDialogFragment() {

    protected lateinit var rootView: View

    protected abstract val layoutId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        rootView = inflater.inflate(layoutId, null)
        return rootView
    }

    override fun show(manager: FragmentManager?, tag: String?) {
        try {
            manager?.let {
                it.beginTransaction().remove(this).commit()
            }
            super.show(manager, tag)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}