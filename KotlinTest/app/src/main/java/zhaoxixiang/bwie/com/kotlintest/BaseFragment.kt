package zhaoxixiang.bwie.com.kotlintest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by admin on 2017/12/28/028.
 */
abstract class BaseFragment:Fragment(){
    var rootView : View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(rootView==null){
            rootView = inflater?.inflate(getLayoutResources(),container,false)
        }
        return rootView
    }

    abstract fun getLayoutResources(): Int
}