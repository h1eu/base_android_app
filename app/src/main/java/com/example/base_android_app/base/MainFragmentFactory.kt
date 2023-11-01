package com.example.base_android_app.base

import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.base_android_app.ui.HomeFragment
import com.example.base_android_app.util.SharedPreferenceUtil
import javax.inject.Inject

class MainFragmentFactory @Inject constructor(
    private val sharedPreUtil: SharedPreferenceUtil
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            HomeFragment::class.java.name -> {
                HomeFragment()
            }
            else -> {
                super.instantiate(classLoader, className)
            }
        }
    }
}