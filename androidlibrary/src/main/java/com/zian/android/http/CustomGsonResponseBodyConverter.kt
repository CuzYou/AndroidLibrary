package com.zian.android.http

import com.google.gson.TypeAdapter
import com.zian.android.config.ConstConfig
import com.zian.android.utils.Logs
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Converter
import java.nio.charset.Charset

/**
 * Just :
 * @author by Zian
 * @date on 2018/7/26.
 */
class CustomGsonResponseBodyConverter<T>(val adapter: TypeAdapter<T>) : Converter<ResponseBody, T> {
    val TYPE_CODE = Charset.forName("UTF-8")

    override fun convert(value: ResponseBody?): T? {
        val bytes = value!!.bytes()
        val json = String(bytes, TYPE_CODE)
        return try {
            val jsonData = JSONObject(json)
            if (jsonData.has(ConstConfig.CODE_NAME)) {
                if (jsonData.getInt(ConstConfig.CODE_NAME) == ConstConfig.CODE_SUCCESS) {
                    adapter.fromJson(json)
                } else {
                    GsonUtil.parseJson(json, ServiceErrorResponse::class.java) as T
                }
            } else {
                Logs.e("Error,json does not have code")
                null
            }
        } catch (e: JSONException) {
            e.printStackTrace()
            null
        } finally {
            value?.close()
        }
    }
}