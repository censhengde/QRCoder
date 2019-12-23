package com.ringle.xinpay.common.qrcode

import android.graphics.Bitmap
import com.ringle.qrcoder.qrcode.IQRCoder
import java.lang.RuntimeException

/**
 * create by 岑胜德
 * on 2019/12/18
 * 说明:二维码API统一封装
 *
 */
object QRCodeHelper : IQRCoder {


    private lateinit var delegate: IQRCoder
    private var inited = false//是否已经初始化
    fun init(delegate: IQRCoder) {
        this.delegate = delegate
        inited = true
    }

    /**
     *生成二维码图片
     */
    override fun encodeQRCode(
        content: String,
        size: Int,
        foregroundColor: Int,
        backgroundColor: Int,
        logoResId: Int,
        callback: (Bitmap) -> Unit
    ) {
        if (!inited) throw RuntimeException("QRCodeHelper 未初始化!")
        return delegate.encodeQRCode(
            content,
            size,
            foregroundColor,
            backgroundColor,
            logoResId,
            callback
        )
    }
}