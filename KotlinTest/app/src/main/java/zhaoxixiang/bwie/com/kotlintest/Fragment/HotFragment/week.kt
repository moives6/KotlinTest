package com.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.PlayMoveActivity
import zhaoxixiang.bwie.com.kotlintest.Prestener.HotprestenerSE
import zhaoxixiang.bwie.com.kotlintest.R
import zhaoxixiang.bwie.com.kotlintest.View.ShowHotView
import zhaoxixiang.bwie.com.kotlintest.adapter.HotAdapter

/**
 * Created by 胡靖宇 on 2017/12/27.
 */
class week: Fragment(), ShowHotView {
    var hp: HotprestenerSE?=null
    var rcw:RecyclerView?=null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
     var view=inflater!!.inflate(R.layout.week, container, false)

         rcw= view.findViewById(R.id.rc_weekweek) as RecyclerView
        hp=HotprestenerSE(this)
        hp!!.pAndm()

        rcw!!.layoutManager= LinearLayoutManager(activity)




        return view
    }

    override fun ShowHotData(hotbean: Hotbean) {

        var adappter= HotAdapter(activity,hotbean)
        rcw!!.setAdapter(adappter)

        adappter.setOnItemClickListener(object :HotAdapter.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {

                val intent = Intent()
                var bundle = Bundle()
                //获取intent对象
                intent.setClass(activity, PlayMoveActivity::class.java)

                bundle.putString("url",hotbean.itemList!!.get(position).data!!.playUrl)
                bundle.putString("imgplay",hotbean.itemList!!.get(position).data!!.cover!!.detail)
                bundle.putString("imgblurred",hotbean.itemList!!.get(position).data!!.cover!!.blurred)
                bundle.putString("title",hotbean.itemList!!.get(position).data!!.title)
                bundle.putString("text",hotbean.itemList!!.get(position).data!!.descriptionEditor)
                bundle.putString("type",hotbean.itemList!!.get(position).data!!.category)
                intent.putExtras(bundle)
                // 获取class是使用::反射
                startActivity(intent)
            }

        })
    }
}