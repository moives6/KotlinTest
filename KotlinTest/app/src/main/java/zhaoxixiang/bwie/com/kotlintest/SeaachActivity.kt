package zhaoxixiang.bwie.com.kotlintest

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.android.synthetic.main.activity_seaach.*
import zhaoxixiang.bwie.com.kotlintest.adapter.SearchAdapter

class SeaachActivity : AppCompatActivity() {

    var data : ArrayList<String> = arrayListOf("脱口秀","城会玩","666","笑cry","漫威",
            "清新","匠心","VR","心理学","舞蹈","品牌广告","粉丝自制","电影相关","萝莉","魔性"
            ,"第一视角","教程","毕业设计","奥斯卡","燃","冰与火之歌","温情","线下campaign","公益")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seaach)

        iv_search_back.setOnClickListener {
            finish()
        }

        iv_search_search.setOnClickListener {
            val search_key=et_search_keyword.text.toString()
            /*if (TextUtils.isEmpty(search_key.trim({it<=' '}))){

            }*/
            if (TextUtils.isEmpty(search_key.trim())){
                Toast.makeText(this@SeaachActivity,"请输入关键字",Toast.LENGTH_LONG).show()
            }else{
                var keyWord=search_key.trim()
                var intent:Intent=Intent(this@SeaachActivity,ResultActivity::class.java)
                intent.putExtra("keyWord",keyWord)
                startActivity(intent)
                finish()
            }
        }
        var adapter:SearchAdapter= SearchAdapter(this@SeaachActivity,data)

        val manager=FlexboxLayoutManager()
        //设置横轴排列
        manager.flexDirection=FlexDirection.ROW
        //设置是否换行
        manager.flexWrap=FlexWrap.WRAP

        search_rlv.layoutManager=manager
        search_rlv.itemAnimator=DefaultItemAnimator()
        search_rlv.adapter=adapter

        adapter.setOnClick(object :SearchAdapter.OnItemClick{
            override fun onItemClick(position: String) {
                var intent:Intent= Intent(this@SeaachActivity,ResultActivity::class.java)
                intent.putExtra("keyWord",position)
                startActivity(intent)
                finish()
            }

        })
    }

}
