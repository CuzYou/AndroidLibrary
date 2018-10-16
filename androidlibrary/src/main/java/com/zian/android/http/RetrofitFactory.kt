package com.zian.android.http

import com.zian.android.config.ConstConfig
import com.zian.android.utils.Logs
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

/**
 * Just : 网络请求
 * @author by Zian
 * @date on 2018/7/26.
 */
class RetrofitFactory private constructor() {

    private val mRetrofit: Retrofit

    init {
        val mOkHttpClient = OkHttpClient.Builder()
                .connectTimeout(ConstConfig.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(ConstConfig.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(ConstConfig.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(InterceptorUtil.LogInterceptor())
                .build()
        Logs.w(ConstConfig.BASE_URL)
        mRetrofit = Retrofit.Builder()
                .baseUrl(ConstConfig.BASE_URL)
                .addConverterFactory(CustomGsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build()

    }


    fun <T> api(t: Class<T>): T {
        return mRetrofit.create(t) as T
    }

    companion object {

        val instance: RetrofitFactory by lazy { RetrofitFactory() }

    }
}