package com.ringle.qrcoder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ringle.qrcoder.qrcode.QRCodeHelper
import kotlinx.android.synthetic.main.fragment_receive_qrcode.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_receive_qrcode)
        initQRCode()
    }

   /**
    *初始化二维码
    */
    private fun initQRCode(){
        QRCodeHelper.encodeQRCode("收款地址",logoResId = R.drawable.resources_img_investment_investment_train_icon,callback={
            //it就是回调的bitmap
            iv_qr_code.setImageBitmap(it)
        })
    }
}
