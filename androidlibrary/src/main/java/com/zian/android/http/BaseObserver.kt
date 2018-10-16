package com.zian.android.http

import android.content.Context
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import com.zian.android.utils.ToastUtil

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
abstract class BaseObserver<T> : Observer<BaseEntity<T>> {


    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: BaseEntity<T>) {
        if (t.isSuccess()) {
            onSuccess(t)
        } else {
            onCodeError(t)
        }
    }

    override fun onError(e: Throwable) {
        onFailure(e, true)
        e.printStackTrace()
    }

    protected abstract fun onSuccess(t: BaseEntity<T>)

    protected abstract fun onFailure(e: Throwable, isNetworkError: Boolean)

    protected abstract fun onCodeError(t: BaseEntity<T>)

}