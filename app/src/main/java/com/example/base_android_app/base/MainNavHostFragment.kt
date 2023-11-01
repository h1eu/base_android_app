package com.example.base_android_app.base

import android.content.Context
import androidx.navigation.fragment.NavHostFragment
import javax.inject.Inject

class MainNavHostFragment: NavHostFragment() {
    @Inject
    lateinit var mainFragmentFactory: MainFragmentFactory
    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = this.mainFragmentFactory
    }
}