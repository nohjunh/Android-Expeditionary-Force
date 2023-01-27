package com.nohjunh.version1.view.preview

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.nohjunh.version1.R

class LoadingDialog(context: Context) : Dialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progressloading)

        // 로딩 중간에 다른 작업을 하지 못하도록
        setCancelable(false)

        // background 투명
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }
}