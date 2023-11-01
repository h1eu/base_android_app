package com.example.base_android_app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

typealias Inflate<T> =(LayoutInflater,ViewGroup?,Boolean) -> T
abstract class BaseFragment<B: ViewBinding>(val inflate: Inflate<B>): Fragment() {
    private lateinit var _binding: B
    protected val binding get() =_binding

    protected var navController: NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        init(view)
        onSubscribeObserver(view)
    }

    abstract fun onSubscribeObserver(view: View)

    abstract fun init(view: View)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(layoutInflater,container, false)
        return _binding.root
    }
}