package zhaoxixiang.bwie.com.kotlintest.Fragment

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.astuetz.PagerSlidingTabStrip
import com.myapplication.PageData
import zhaoxixiang.bwie.com.kotlintest.R

/**
 * Created by admin on 2017/12/27/027.
 */
class FaXianFragment: android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.find_fragment, null)


        return view
    }
}