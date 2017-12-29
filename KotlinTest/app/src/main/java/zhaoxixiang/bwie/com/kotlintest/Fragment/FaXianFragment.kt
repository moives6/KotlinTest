package zhaoxixiang.bwie.com.kotlintest.Fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import com.astuetz.PagerSlidingTabStrip
import com.myapplication.PageData

import kotlinx.android.synthetic.main.find_fragment.*
import zhaoxixiang.bwie.com.kotlintest.FaxianXiangqingActivity
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.FindBean
import zhaoxixiang.bwie.com.kotlintest.Prestener.FaxianPrestener
import zhaoxixiang.bwie.com.kotlintest.R
import zhaoxixiang.bwie.com.kotlintest.View.FaxianView
import zhaoxixiang.bwie.com.kotlintest.adapter.FaxianAdapter

/**
 * Created by admin on 2017/12/27/027.
 */
class FaXianFragment: Fragment() ,FaxianView{

    var presenter: FaxianPrestener? =null

    var adapter: FaxianAdapter? =null
    var faxianrlv:RecyclerView?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate( R.layout.find_fragment,container, false)

        faxianrlv=view.findViewById(R.id.faxianrlv) as RecyclerView

        presenter=FaxianPrestener(this)
        presenter!!.pm()

        return view
    }
    override fun showData(faxian: List<FindBean>) {

        //fxtv.setText(faxian.get(2).name)
        Log.i("xxx",faxian.get(2).name)
        //faxianrlv?.layoutManager=LinearLayoutManager(activity)
        faxianrlv?.layoutManager= GridLayoutManager(activity,2) as RecyclerView.LayoutManager?
        //list=faxian
        var adapter= FaxianAdapter(activity,faxian)
        faxianrlv?.adapter=adapter

        adapter.setOnClick(object :FaxianAdapter.OnItemClick{
            override fun onItemClick(position: FindBean) {

                val intent=Intent(activity,FaxianXiangqingActivity::class.java)

                intent.putExtra(FaxianXiangqingActivity::name.get(FaxianXiangqingActivity()),position.name)

                startActivity(intent)
            }

        })
    }
}
