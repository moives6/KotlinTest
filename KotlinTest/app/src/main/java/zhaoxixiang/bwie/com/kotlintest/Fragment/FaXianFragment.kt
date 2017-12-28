package zhaoxixiang.bwie.com.kotlintest.Fragment

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.astuetz.PagerSlidingTabStrip
import com.myapplication.PageData
import kotlinx.android.synthetic.main.find_fragment.*
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.FindBean
import zhaoxixiang.bwie.com.kotlintest.Prestener.FaxianPrestener
import zhaoxixiang.bwie.com.kotlintest.R
import zhaoxixiang.bwie.com.kotlintest.View.FaxianView
import zhaoxixiang.bwie.com.kotlintest.adapter.FaxianAdapter

/**
 * Created by admin on 2017/12/27/027.
 */
class FaXianFragment: android.support.v4.app.Fragment() ,FaxianView{

    var presenter: FaxianPrestener? =null
    var adapter: FaxianAdapter? =null
    var list:List<FindBean>?=null
    override fun showData(faxian: List<FindBean>) {
        //Toast.makeText(activity,faxian.get(0).description,Toast.LENGTH_LONG).show()
        fxtv.setText(faxian.get(0).name)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.find_fragment, null)

        adapter= FaxianAdapter(activity,list!!)
        faxian_rlv.layoutManager=GridLayoutManager(activity,2)
        faxian_rlv.adapter=adapter
        presenter=FaxianPrestener(this)
        presenter!!.pm()

        return view
    }
}