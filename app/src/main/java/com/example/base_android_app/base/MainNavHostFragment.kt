package com.example.base_android_app.base

import android.content.Context
import androidx.navigation.fragment.NavHostFragment

class MainNavHostFragment: NavHostFragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = this.
    }
}