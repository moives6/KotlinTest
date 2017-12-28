package zhaoxixiang.bwie.com.kotlintest.Fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    var list:List<FindBean>?=ArrayList<FindBean>()
    override fun showData(faxian: List<FindBean>) {

        fxtv.setText(faxian.get(2).name)

        list=faxian
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.find_fragment, null)

        presenter=FaxianPrestener(this)
        presenter!!.pm()
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter= FaxianAdapter(activity,list!!)
        faxianrlv.layoutManager=LinearLayoutManager(context)
        faxianrlv.adapter=adapter
    }
}