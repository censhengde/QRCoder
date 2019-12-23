package com.ringle.qrcoder.qrcode

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder
import com.ringle.qrcoder.qrcode.IQRCoder
import kotlinx.coroutines.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult

/**
 * create by 岑胜德
 * on 2019/12/18
 * 说明:QRCoder真实工作类
 *
 */
@Suppress("CAST_NEVER_SUCCEEDS")
class ActualQRCoder(val context: Context) : IQRCoder {


    override fun encodeQRCode(
        content: String,
        size: Int,
        foregroundColor: Int,
        backgroundColor: Int,
        logoResId: Int,
        callback: (Bitmap) -> Unit
    ) {
             //协程开启异步任务
             val future=doAsyncResult {
            //创建logo
            val bitmap = BitmapFactory.decodeResource(context.resources, logoResId)
            //表达式结果是Bitmap
            if (bitmap == null) {
                QRCodeEncoder.syncEncodeQRCode(
                    content,
                    size,
                    foregroundColor,
                    backgroundColor,
                    null
                )
            } else {

                QRCodeEncoder.syncEncodeQRCode(
                    content,
                    size,
                    foregroundColor,
                    backgroundColor,
                    bitmap
                )
            }

             }
            //等待结果(非阻塞)
           val result= future.get() as Bitmap
            //回调结果
            callback(result)
    }
}