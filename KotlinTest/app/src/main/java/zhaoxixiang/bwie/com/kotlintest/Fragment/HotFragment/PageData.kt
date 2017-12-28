package com.myapplication

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import android.widget.Switch

/**
 * Created by 胡靖宇 on 2017/12/27.
 */
class PageData(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        var fragment:Fragment?=null
        when(position){
            0->fragment=week()
            1->fragment=Month()
            2->fragment=All()

        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
       when(position){
           0->return "周排行"
           1->return "月排行"
           2->return "总排行"
       }
        return ""
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        super.destroyItem(container, position, `object`)
    }
}