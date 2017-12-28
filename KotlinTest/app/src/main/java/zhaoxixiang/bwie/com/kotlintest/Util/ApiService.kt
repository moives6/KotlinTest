package zhaoxixiang.bwie.com.kotlintest.Util

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean

/**
 * Created by 胡靖宇 on 2017/12/27.
 */

interface ApiService {

    //获取热门排行信息
    @GET("v3/ranklist")
    fun getHotData(@Query("num") num :Int, @Query("strategy") strategy :String,
                   @Query("udid") udid :String, @Query("vc") vc :Int) : Observable<Hotbean>
}
