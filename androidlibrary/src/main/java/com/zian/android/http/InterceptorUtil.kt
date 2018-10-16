package com.zian.android.http

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import com.zian.android.utils.Logs

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
class InterceptorUtil {


    companion object {
        val TAG = "****"

        fun LogInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Logs.w(TAG, it)
            }).setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        fun HeaderInterceptor(): Interceptor {
            return Interceptor { it ->
                val resp = it.proceed(it.request())
                val cookies = resp.headers("Set-Cookie")
                var cookieStr = ""
                if (cookies!!.size > 0) {
                    for (str: String in cookies) {
                        cookieStr += str
                    }
                }
                resp
            }
        }

        fun AddCookiesInterceptor(): Interceptor {
            return Interceptor { chain ->
                val request = chain.request()
                val builder = request.newBuilder()
                val cookies = "存储的cookie"
                builder.addHeader("cookie", cookies)
                chain.proceed(builder.build())
            }
        }

/*        fun addQueryParameterInterceptor(): Interceptor {
            return Interceptor { chain ->
                val originalRequest = chain.request()
                var request: Request? = null
                if (originalRequest.method() == "GET") {
                    request = addGetPublicParams(originalRequest)
                } else if (originalRequest.method() == "POST") {
                    request = addPostPublicParams(originalRequest)
                }
                chain.proceed(request!!)
            }
        }

        private fun addGetPublicParams(request: Request): Request {
            var modifiedUrl = request.url().newBuilder()
                    .addQueryParameter("token", UserUtil.TOKEN)
                    .addQueryParameter("timestamp", System.currentTimeMillis().toString())
                    .build()
            //添加签名
            val nameSet = modifiedUrl.queryParameterNames()
            val nameList = arrayListOf<String>()
            nameList.addAll(nameSet)
            //nameList.sort()
            var buffer = StringBuilder()
            for (i in nameList.indices) {
                if (!TextUtils.isEmpty(nameList[i])) {
                    buffer.append("&")
                            .append(nameList[i])
                            .append("=")
                            .append(if (modifiedUrl.queryParameterValues(nameList[i]) != null && modifiedUrl.queryParameterValues(nameList[i]).size > 0) modifiedUrl.queryParameterValues(nameList[i])[0] else "")
                }
            }
            modifiedUrl = modifiedUrl.newBuilder()
                    .addQueryParameter("sign", MD5Util.getMD5(buffer.toString()))
                    .build()
            return request.newBuilder().url(modifiedUrl).build()
        }

        private fun addPostPublicParams(request: Request): Request {
            if (request.body() is FormBody) {
                var formBody = request.body() as FormBody
                val bodyBuilder = FormBody.Builder()
                for (i in 0 until formBody.size()) {
                    bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i))
                }
                formBody = bodyBuilder.addEncoded("token", UserUtil.TOKEN)
                        .addEncoded("timestamp", System.currentTimeMillis().toString())
                        .build()

                val bodyMap = ArrayMap<String, String>()
                val nameList = arrayListOf<String>()
                for (i in 0 until formBody.size()) {
                    nameList.add(formBody.encodedName(i))
                    bodyMap[formBody.encodedName(i)] = URLDecoder.decode(formBody.encodedValue(i), "UTF-8")
                }

                val builder = StringBuilder()
                for (i in nameList.indices) {
                    if (!TextUtils.isEmpty(nameList[i])) {
                        builder.append(nameList[i])
                                .append("=")
                                .append(URLDecoder.decode(bodyMap[nameList[i]], "UTF-8"))
                                .append("&")
                    }
                }
                var paramsStr = builder.toString()
                if (builder.endsWith("&")) {
                    paramsStr = paramsStr.substring(0, builder.length-1)
                }
                formBody = bodyBuilder
                        .addEncoded("sign", MD5Util.getMD5(paramsStr))
                        .build()
                return request.newBuilder().post(formBody).build()
            }
            return request
        }*/
    }
}