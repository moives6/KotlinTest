package zhaoxixiang.bwie.com.kotlintest.Util

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean


/**
 * Created by 胡靖宇 on 2017/12/27.
 */
interface API {
    val url: String
        get() = "http://baobab.kaiyanapp.com/api/"


}