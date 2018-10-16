package com.zian.android.utils

import android.content.Context
import android.text.TextUtils
import android.widget.ImageView
import com.zian.android.R
import com.zian.android.utils.glide.GlideCircleTransform

/**
 * Just :
 * @author by Zian
 * @date on 2018/8/9.
 */
object GlideUtil {

    //加载图片
    fun loadImage(context: Context, imageUrl: String?, imageView: ImageView?) {
        if (!TextUtils.isEmpty(imageUrl)) {
            GlideApp.with(context)
                    .load(imageUrl)
                    //.placeholder()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView!!)
        } else {
            GlideApp.with(context)
                    .load("empty")
                    //.placeholder()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView!!)
        }

    }

    //加载gif图片
    fun loadGifImage(context: Context, gifImageUrl: Any?, imageView: ImageView?) {
        if (gifImageUrl != null) {
            GlideApp.with(context)
                    .load(gifImageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(imageView!!)
        } else {
            GlideApp.with(context)
                    .load("empty")
                    //.placeholder()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView!!)
        }
    }

    //加载圆形图片
    fun loadCircleImage(context: Context, imageUrl: String?, imageView: ImageView?) {
        GlideApp.with(context)
                .load(imageUrl)
                .transform(GlideCircleTransform())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView!!)
    }

    //加载用户头像
    fun loadHeaderImage(context: Context, imageUrl: String?, imageView: ImageView?) {
        GlideApp.with(context)
                .load(imageUrl)
                .placeholder(R.mipmap.ic_user)
                .transform(GlideCircleTransform())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView!!)
    }

}