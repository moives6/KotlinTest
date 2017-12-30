package zhaoxixiang.bwie.com.kotlintest.Model.bean

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.RetrofitUtils
import zhaoxixiang.bwie.com.kotlintest.Util.API
import zhaoxixiang.bwie.com.kotlintest.Util.ApiService

/**
 * Created by admin on 2017/12/28/028.
 */
class DetailModel{
    fun getData(name:String):Flowable<Hotbean>{
       /* val retrofit=Retrofit.Builder().baseUrl(API.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()*/
       // val apiService=retrofit.create(ApiService::class.java)
       // val flowable=apiService.getFindDetailData(name,"date","26868b32e808498db32fd51fb422d00175e179df",83)

        val ser=RetrofitUtils.instance.getApiService(API.url,ApiService::class.java)
        val ober=ser.getFindDetailData(name,"date","26868b32e808498db32fd51fb422d00175e179df",83)
        return ober
    }
    fun getMoreData(start:Int,name:String):Flowable<Hotbean>{
        /* val retrofit=Retrofit.Builder().baseUrl(API.url)
                 .addConverterFactory(GsonConverterFactory.create())
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .build()*/
        // val apiService=retrofit.create(ApiService::class.java)
        // val flowable=apiService.getFindDetailData(name,"date","26868b32e808498db32fd51fb422d00175e179df",83)

        val ser=RetrofitUtils.instance.getApiService(API.url,ApiService::class.java)
        val ober=ser.getFindDetailMoreData(start,10,name,"date")
        return ober
    }
}