package zhaoxixiang.bwie.com.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_faxian_xiangqing.*
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.Prestener.FaxianDetailPresenter
import zhaoxixiang.bwie.com.kotlintest.View.FaxianDetailView
import zhaoxixiang.bwie.com.kotlintest.adapter.DetailAdapter

class FaxianXiangqingActivity : BaseActivity<FaxianDetailPresenter>(),FaxianDetailView {
    //val name="zhaoxixiang.bwie.com.kotlintest.FaxianXiangqingActivity.intent"
    val name: String? =null
    var nameS:String? =null
    var list:ArrayList<Hotbean.ItemListBean.DataBean> = ArrayList()
    var adapter:DetailAdapter?=null
    override fun showData(bean: Hotbean) {
        val bean1:Hotbean=bean

        if (list.size>0){
            list.clear()
        }
        bean.itemList?.forEach {
            it.data?.let {
                it1->list.add(it1)
            }
        }

    }

    override fun layoutId(): Int {
        return R.layout.activity_faxian_xiangqing
    }

    override fun initView() {
        nameS=intent.getStringExtra(name)
        detail_tv.setText(nameS)

        detail_back.setOnClickListener{
            finish()
        }
        adapter=DetailAdapter(this,list)
        detail_rlv.layoutManager=LinearLayoutManager(this@FaxianXiangqingActivity)
        detail_rlv.adapter=adapter
    }

    override fun getPresenter(): FaxianDetailPresenter {
        return FaxianDetailPresenter(this)
    }

    override fun initData() {
        presenter!!.pm(nameS!!)
    }



}
