package com.example.base_android_app.util

import android.os.SystemClock
import android.view.View
import android.view.View.OnClickListener

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}

fun View.invisible(){
    this.visibility = View.INVISIBLE
}

fun View.setPreventDoubleClick(debounceTime: Long = 500, onAction: () -> Unit){
    this.setOnClickListener(object : OnClickListener{
        private var lastClickTime: Long = 0
        override fun onClick(v: View?) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            onAction.invoke()
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}
