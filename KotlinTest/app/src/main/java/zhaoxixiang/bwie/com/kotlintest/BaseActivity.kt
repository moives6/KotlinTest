package zhaoxixiang.bwie.com.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity<T> : AppCompatActivity() {

    var presenter: T? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())

        initView()
        presenter=getPresenter()
        initData()

    }

    //加载布局
    abstract fun layoutId(): Int

    abstract fun initView()
    //内部的internal
    internal abstract fun getPresenter():T
    abstract fun initData()

}
