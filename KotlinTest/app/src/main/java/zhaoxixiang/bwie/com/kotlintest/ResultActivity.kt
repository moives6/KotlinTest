package zhaoxixiang.bwie.com.kotlintest

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_result.*
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.Prestener.ResultPresenter
import zhaoxixiang.bwie.com.kotlintest.View.ResultView
import zhaoxixiang.bwie.com.kotlintest.adapter.ResultAdapter

class ResultActivity : BaseActivity<ResultPresenter>(), ResultView {

    val name: String? = "keyWord"
    var nameS: String? = null
    var mstart: Int = 10

    var list = ArrayList<Hotbean.ItemListBean.DataBean>()

    var adapter: ResultAdapter? = null
    override fun showData(bean: Hotbean) {

        bean.itemList!!.forEach {
            it.data?.let { it1 ->
                list.add(it1)
            }
        }
        adapter?.notifyDataSetChanged()
    }

    override fun layoutId(): Int {
        return R.layout.activity_result
    }

    override fun initView() {

        nameS = intent.getStringExtra(name)
        result_tv.setText("'" + nameS + "'" + "相关")
        result_back.setOnClickListener {
            finish()
        }

        adapter = ResultAdapter(this@ResultActivity, list)
        result_rlv.layoutManager = LinearLayoutManager(this)
        result_rlv.adapter = adapter

        result_rlv.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManager: LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPositon = layoutManager.findLastVisibleItemPosition()
                if (newState==RecyclerView.SCROLL_STATE_IDLE&&lastPositon==list.size-1){
                    mstart=mstart.plus(10)
                    presenter!!.getData(nameS!!,mstart)
                }
            }
        })


    }

    override fun getPresenter(): ResultPresenter {

        return ResultPresenter(this)
    }

    override fun initData() {

        presenter!!.getData(nameS!!, mstart)
    }

}
