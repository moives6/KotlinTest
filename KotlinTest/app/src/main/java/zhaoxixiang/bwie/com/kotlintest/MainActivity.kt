package zhaoxixiang.bwie.com.kotlintest

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Build
import android.view.View
import com.facebook.drawee.backends.pipeline.Fresco
import com.myapplication.Home
import com.myapplication.Hot
import com.myapplication.My
import zhaoxixiang.bwie.com.kotlintest.Fragment.FaXianFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this);
        setContentView(R.layout.activity_main)
        bottom_tab_bar.init(supportFragmentManager)
                .setImgSize(50f, 50f)
                .setFontSize(10f)
                .setTabPadding(5f, 5f, 5f)
                .setChangeColor(Color.BLACK, Color.DKGRAY)
                .addTabItem("首页", R.drawable.home_selected, R.drawable.home_normal, Home::class.java)
                .addTabItem("发现", R.drawable.find_selected, R.drawable.find_normal, FaXianFragment::class.java)
                .addTabItem("热门", R.drawable.hot_selected, R.drawable.hot_normal, Hot::class.java)
                .addTabItem("我的", R.drawable.mine_selected, R.drawable.mine_normal, My::class.java)

                .isShowDivider(false)
                .setOnTabChangeListener { position, name ->
                    when (position) {
                        0 -> main_tv.setText(name)
                        1 -> main_tv.setText(name)
                        2 -> main_tv.setText(name)

                    }
                    when (position) {
                        0 -> rl.visibility = View.VISIBLE
                        1 -> rl.visibility = View.VISIBLE
                        2 -> rl.visibility = View.VISIBLE
                        3 -> rl.visibility = View.GONE
                    }
                }
        main_sousuo.setOnClickListener {
            var intent=Intent(this@MainActivity,SeaachActivity::class.java)
            startActivity(intent)
        }

    }

    //设置了沉浸式
    /*override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            val decorView = window.decorView
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }*/
}
