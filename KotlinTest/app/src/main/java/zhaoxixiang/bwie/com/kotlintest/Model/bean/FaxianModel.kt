package zhaoxixiang.bwie.com.kotlintest.Model.bean

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.FindBean
import zhaoxixiang.bwie.com.kotlintest.Util.API
import zhaoxixiang.bwie.com.kotlintest.Util.ApiService

/**
 * Created by admin on 2017/12/28/028.
 */
class FaxianModel{
    fun getData(): Flowable<List<FindBean>> {
        val retrofit=Retrofit.Builder().baseUrl(API.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        val apiService=retrofit.create(ApiService::class.java)
        val observable=apiService.getFindData()
        return observable
    }
}