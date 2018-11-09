package com.zian.android.utils

import android.view.View
import android.widget.EditText
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Just :
 * @author by Zian
 * @date on 2018/8/9.
 */
object RxUtil {

    //倒计时
    fun timeCountDown(time: Int): Observable<Int> {
        var countTime = time
        if (countTime < 0) countTime = 0

        return Observable.interval(0, 1, TimeUnit.SECONDS)
            .map { t ->
                countTime - t.toInt()
            }
            .take((countTime + 1).toLong())
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * @param interval:毫秒
     */
    fun editTextChange(editText: EditText, interval: Long): Observable<CharSequence> {
        return RxTextView.textChanges(editText)
            .debounce(interval, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * @param interval:毫秒
     */
    fun viewClick(view: View, interval: Long): Observable<Any> {
        return RxView.clicks(view)
            .throttleFirst(interval, TimeUnit.SECONDS)
    }

    fun viewClick(view: View): Observable<Any> {
        return viewClick(view, 2)
    }

}