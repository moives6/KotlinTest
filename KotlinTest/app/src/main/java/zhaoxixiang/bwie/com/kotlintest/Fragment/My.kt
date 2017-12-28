package com.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import zhaoxixiang.bwie.com.kotlintest.R

/**
 * Created by 胡靖宇 on 2017/12/27.
 */
class My : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view=inflater!!.inflate(R.layout.my, container, false)

        return view
    }
}