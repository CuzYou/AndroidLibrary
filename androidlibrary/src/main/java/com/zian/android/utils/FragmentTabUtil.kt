package com.zian.android.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.RadioButton
import android.widget.RadioGroup

/**
 * Just : 主界面 底部切换tab工具类
 * @author by Zian
 * @date on 2018/8/1.
 */
class FragmentTabUtil : RadioGroup.OnCheckedChangeListener {

    private  val fragmentManager: FragmentManager
    private  val fragmentList: MutableList<Fragment>
    //默认选中展示第一个fragment
    private var fragmentContentId = 0
    private var radioGroup: RadioGroup
    private var onRgsExtraCheckedChangedListener: OnRgsExtraCheckedChangedListener? = null
    private var currentTab = 0

    constructor(fragmentManager: FragmentManager, fragmentList: MutableList<Fragment>, fragmentContentId: Int,
                radioGroup: RadioGroup, onRgsExtraCheckedChangedListener: OnRgsExtraCheckedChangedListener?) : this(fragmentManager, fragmentList, fragmentContentId, radioGroup, 0, onRgsExtraCheckedChangedListener)

    constructor(fragmentManager: FragmentManager, fragmentList: MutableList<Fragment>, fragmentContentId: Int,
                radioGroup: RadioGroup, fragmentCheckPosition: Int, onRgsExtraCheckedChangedListener: OnRgsExtraCheckedChangedListener?) {
        this.fragmentManager = fragmentManager
        this.fragmentList = fragmentList
        this.fragmentContentId = fragmentContentId
        this.radioGroup = radioGroup
        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener
        if (fragmentCheckPosition < fragmentList.size) {
            fragmentManager.beginTransaction().add(fragmentContentId, fragmentList[fragmentCheckPosition]).commit()
        } else {
            fragmentManager.beginTransaction().add(fragmentContentId, fragmentList[0]).commit()
        }
        radioGroup.setOnCheckedChangeListener(this)
        (radioGroup.getChildAt(fragmentCheckPosition) as RadioButton).isChecked = true
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

        for (i in 0 until radioGroup.childCount) {
            if (radioGroup.getChildAt(i).id == checkedId) {
                val fragment = fragmentList[i]
                val ft = fragmentManager.beginTransaction()
                getCurrentFragment().onPause()
                getCurrentFragment().onStop()
                if (fragment.isAdded) {
                    fragment.onStart()
                    fragment.onResume()
                } else {
                    ft.add(fragmentContentId, fragment)
                    ft.commit()
                }
                showTab(i)
                onRgsExtraCheckedChangedListener?.OnRgsExtraCheckedChanged(radioGroup, checkedId, i)
            }
        }
    }

    //切换tab
    fun showTab(index: Int) {
        for (i in 0 until fragmentList.size) {
            val fragment = fragmentList[i]
            val ft = fragmentManager.beginTransaction()
            if (index == i) {
                ft.show(fragment)
            } else {
                ft.hide(fragment)
            }
            ft.commit()
        }
        currentTab = index
    }

    fun getCurrentFragment(): Fragment {
        return fragmentList[currentTab]
    }

    fun setOnRgsExtraCheckedChangedListener(onRgsExtraCheckedChangedListener: OnRgsExtraCheckedChangedListener) {
        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener
    }

    interface OnRgsExtraCheckedChangedListener {
        fun OnRgsExtraCheckedChanged(radioGroup: RadioGroup, checkedId: Int, index: Int)
    }
}