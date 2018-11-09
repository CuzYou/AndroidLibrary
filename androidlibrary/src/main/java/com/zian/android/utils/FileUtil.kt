package com.zian.android.utils

import com.zian.android.utils.Logs
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class FileUtil {

    companion object {
        val instance: FileUtil by lazy { FileUtil() }
    }

    /**
     * 生成文件写入文件内容 并返回文件路径
     * @param fileName 文件名 abc.json
     * @param filePath 文件路径 projcet/app/file
     * @param fileContents 文件内容
     */
    fun makeFile(fileName: String, filePath: String, fileContents: String): String {
        try {
            //生成文件目录
            val dir = File(filePath)
            Logs.w(dir.path)
            if (!dir.exists()) {
                dir.mkdirs()
            }
            //生成文件
            val file = File(filePath, fileName)
            Logs.w(file.path)
            //如果文件存在则删除重新生成
            if (file.exists()) {
                file.delete()
            }
            file.createNewFile()
            //写入内容
            val fos = FileOutputStream(file)
            val osw = OutputStreamWriter(fos)
            osw.write(fileContents)
            osw.flush()
            osw.close()
            fos.close()
            return file.path
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    /**
     * 读取文件内容
     */
    fun readFile(file: File): String {
        Logs.w("readFile",file.path)
        var fileContents = ""
        return try {
            val fis = FileInputStream(file)
            val length = fis.available()
            val buffer = ByteArray(length)
            fis.read(buffer)
            fileContents = String(buffer)
            fis.close()
            Logs.w(fileContents)
            fileContents
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
}