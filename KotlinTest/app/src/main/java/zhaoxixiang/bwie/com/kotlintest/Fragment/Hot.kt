package com.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.astuetz.PagerSlidingTabStrip
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.Prestener.HotprestenerSE
import zhaoxixiang.bwie.com.kotlintest.R
import zhaoxixiang.bwie.com.kotlintest.View.ShowHotView

/**
 * Created by 胡靖宇 on 2017/12/27.
 */
class Hot : Fragment() {




    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view=inflater!!.inflate(R.layout.hot, container, false)
        val vp = view.findViewById(R.id.vpv) as ViewPager
        val tbs=view.findViewById(R.id.tabs)as PagerSlidingTabStrip

        var   pd= PageData(activity.getSupportFragmentManager())
        vp.adapter=pd

        tbs.setViewPager(vp)
        return view
    }


}