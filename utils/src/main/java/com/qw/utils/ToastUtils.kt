package com.qw.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by qinwei on 2022/11/13 21:07
 * email: qinwei_it@163.com
 */
object ToastUtils : IToast {
    private var toast: IToast? = null

    fun injectToast(iToast: IToast) {
        this.toast = iToast
    }

    override fun show(msg: Int) {
        toast?.show(msg)
    }

    override fun show(msg: String) {
        toast?.show(msg)
    }

    override fun showLong(msg: Int) {
        toast?.showLong(msg)
    }

    override fun showLong(msg: String) {
        toast?.showLong(msg)
    }

}

interface IToast {
    fun show(msg: Int)
    fun show(msg: String)
    fun showLong(msg: Int)
    fun showLong(msg: String)
}

class ToastImpl(private val context: Context) : IToast {
    override fun show(msg: Int) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun show(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showLong(msg: Int) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showLong(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}