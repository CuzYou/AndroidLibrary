package com.zian.android.base

import android.content.Context
import java.io.InputStream

/**
 * Just :
 * @author by Zian
 * @date on 2018/8/9.
 */

@GlideModule
class OkHttpLibraryGlideModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory())
    }
}