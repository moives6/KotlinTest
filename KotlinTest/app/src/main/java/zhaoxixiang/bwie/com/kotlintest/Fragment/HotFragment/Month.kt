package com.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.R
import zhaoxixiang.bwie.com.kotlintest.View.ShowHotView

/**
 * Created by 胡靖宇 on 2017/12/27.
 */
class Month : Fragment(),ShowHotView {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
     var view=inflater!!.inflate(R.layout.month, container, false)

        return view
    }

    override fun ShowHotData(hotbean: Hotbean) {

    }
}