package zhaoxixiang.bwie.com.kotlintest

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
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
    var mstart: Int = 10
    var list:ArrayList<Hotbean.ItemListBean.DataBean> = ArrayList()
    var refresh:Boolean=false
    var adapter:DetailAdapter?=null
    override fun showData(bean: Hotbean) {
        //val bean1:Hotbean=bean
        if (refresh){
            refresh=false
            detail_refresh.isRefreshing=false
            if (list.size>0){
                list.clear()
            }
        }

        bean.itemList?.forEach {
            it.data?.let {
                it1->list.add(it1)
            }
        }
        adapter!!.notifyDataSetChanged()
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
        adapter!!.setOnClick(object :DetailAdapter.OnItemClick{
            override fun onItemClick(position: Int) {
                val intent = Intent()
                var bundle = Bundle()
                //获取intent对象
                intent.setClass(this@FaxianXiangqingActivity,PlayMoveActivity::class.java)

                bundle.putString("url",list.get(position).playUrl)
                bundle.putString("imgplay",list.get(position).cover!!.detail)
                bundle.putString("imgblurred",list.get(position).cover!!.blurred)
                bundle.putString("title",list.get(position).title)
                bundle.putString("text", list.get(position).descriptionPgc as String?)
                bundle.putString("type",list.get(position).category)
                intent.putExtras(bundle)
                // 获取class是使用::反射
                startActivity(intent)
            }

        })
        detail_refresh.setOnRefreshListener {
            if (!refresh){
                refresh=true
                presenter!!.pm(nameS!!)
                //detail_refresh.isRefreshing=false
            }

        }

        detail_rlv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManager: LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPositon = layoutManager.findLastVisibleItemPosition()
                if (newState==RecyclerView.SCROLL_STATE_IDLE&&lastPositon==list.size-1){
                   presenter!!.pmMore(mstart,nameS!!)
                    mstart=mstart.plus(10)
                }
            }
        })
    }

    override fun getPresenter(): FaxianDetailPresenter {
        return FaxianDetailPresenter(this)
    }

    override fun initData() {
        presenter!!.pm(nameS!!)
    }



}
