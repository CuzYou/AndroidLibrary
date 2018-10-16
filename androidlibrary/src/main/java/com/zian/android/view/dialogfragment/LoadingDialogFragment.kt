package com.zian.android.view.dialogfragment

import android.support.v4.app.FragmentManager
import com.zian.android.R
import com.zian.android.base.BaseDialogFragment

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
class LoadingDialogFragment : BaseDialogFragment(){

    override val layoutId: Int
        get() = R.layout.layout_dialog_loading_view


    override fun show(manager: FragmentManager?, tag: String?) {
        try {
            //在每个add事务前增加一个remove事务，防止连续的add
            manager?.let {
                it.beginTransaction().remove(this).commit()
            }
            //manager!!.beginTransaction().remove(this).commit()
            super.show(manager, tag)
        } catch (e: Exception) {
            //同一实例使用不同的tag会异常,这里捕获一下
            e.printStackTrace()
        }

    }
}