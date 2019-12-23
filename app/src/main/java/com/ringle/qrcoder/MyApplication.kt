package com.ringle.qrcoder

import android.app.Application
import com.ringle.qrcoder.qrcode.ActualQRCoder
import com.ringle.qrcoder.qrcode.QRCodeHelper

/**
 * create by 岑胜德
 * on 2019/12/18
 * 说明:
 *
 */
class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        //初始化框架
        QRCodeHelper.init(ActualQRCoder(this))
    }
}