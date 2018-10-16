package com.zian.android.http

import io.reactivex.observers.DisposableObserver

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/30.
 */
abstract class BaseDispoableObserver<T> : DisposableObserver<BaseEntity<T>>() {

    override fun onComplete() {

    }

    override fun onNext(t: BaseEntity<T>) {
        if (t.isSuccess()) {
            onSuccess(t)
        } else {
            onCodeError(t)
        }
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        onFailure(e)
    }

    protected abstract fun onSuccess(t: BaseEntity<T>)

    protected abstract fun onCodeError(t: BaseEntity<T>)

    protected abstract fun onFailure(e: Throwable)



}