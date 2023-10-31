package com.example.base_android_app.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.base_android_app.ui.HomeFragment

class MainFragmentFactory : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
//            HomeFragment::class.java.name -> {
//                HomeFragment()
//            }
            else -> {
                super.instantiate(classLoader, className)
            }
        }
    }
}