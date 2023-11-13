package com.example.base_android_app.base

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

abstract class BaseDialogFragment<B: ViewDataBinding> : DialogFragment() {
    protected lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, getLayoutResource(), container,false
        )
        if (this.dialog!!.window != null) {
            this.dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
            this.dialog!!.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        val windowManagerLayoutParams = this.dialog!!.window!!.attributes
        windowManagerLayoutParams.gravity = getGravityForDialog()
        this.dialog!!.window!!.attributes = windowManagerLayoutParams
        init(savedInstanceState,binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    abstract fun initView(view: View?)

    override fun show(manager: FragmentManager, tag: String?) {
        var transaction = manager.beginTransaction()
        val prevFm = manager.findFragmentByTag(tag)
        if (prevFm != null){
            transaction.remove(prevFm)
        }
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
        transaction = manager.beginTransaction()
        show(transaction,tag)
    }

    protected fun setWidthForDialog(widthDialog: Int){
        if (dialog?.window != null){
            dialog?.window?.setLayout(
                resources.displayMetrics.widthPixels * widthDialog / 10,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
        }
    }

    protected fun setFullScreenForDialog(){
        if (dialog?.window != null){
            dialog?.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
        }
    }

    protected fun setFullWidthForDialog(){
        if (dialog?.window != null){
            dialog?.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
        }
    }

    protected abstract fun getLayoutResource(): Int

    protected abstract fun getGravityForDialog(): Int

    protected abstract fun init(saveInstanceState: Bundle?, view: View?)

}