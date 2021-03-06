package zhaoxixiang.bwie.com.kotlintest.Util

import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.FindBean
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.HomeBean
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean

/**
 * Created by 胡靖宇 on 2017/12/27.
 */

interface ApiService {

    //获取首页第一页数据
    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getHomeData(): Flowable<HomeBean>


    //获取首页第一页之后的数据  ?date=1499043600000&num=2
    @GET("v2/feed")
    fun getHomeMoreData(@Query("date") date :String,@Query("num") num :String) : Flowable<HomeBean>

    //获取发现频道信息
    @GET("v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getFindData() : Flowable<List<FindBean>>
    //获取热门排行信息
    @GET("v3/ranklist")
    fun getHotData(@Query("num") num :Int, @Query("strategy") strategy :String,
                   @Query("udid") udid :String, @Query("vc") vc :Int) : Flowable<Hotbean>
    //获取发现频道详情信息
    @GET("v3/videos")
    fun getFindDetailData(@Query("categoryName") categoryName :String,@Query("strategy") strategy :String,
                          @Query("udid") udid :String,@Query("vc") vc :Int) : Flowable<Hotbean>

    //获取发现详情加载更多消息
    @GET("v3/videos")
    fun getFindDetailMoreData(@Query("start") start :Int,@Query("num") num :Int,
                              @Query("categoryName") categoryName :String,@Query("strategy") strategy :String) : Flowable<Hotbean>
    //获取关键词搜索相关信息
    @GET("v1/search")
    fun getSearchData(@Query("num") num :Int,@Query("query") query :String,
                      @Query("start") start :Int) : Flowable<Hotbean>
}
