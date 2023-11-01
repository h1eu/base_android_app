package com.example.base_android_app.util

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferenceUtil @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val editor: SharedPreferences.Editor
) {
    var isFirstOpenAp: Boolean
        get() = sharedPreferences.getBoolean(KEY_IS_FIRST_OPEN_APP,false)
        set(value) {
            editor.putBoolean(KEY_IS_FIRST_OPEN_APP,value)
            editor.commit()
        }


    companion object{
        const val KEY_IS_FIRST_OPEN_APP = "is_first_open_app"
    }
}