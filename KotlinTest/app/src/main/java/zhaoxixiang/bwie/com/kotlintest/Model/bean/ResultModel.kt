package zhaoxixiang.bwie.com.kotlintest.Model.bean

import io.reactivex.Flowable
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.RetrofitUtils
import zhaoxixiang.bwie.com.kotlintest.Util.API
import zhaoxixiang.bwie.com.kotlintest.Util.ApiService

/**
 * Created by admin on 2017/12/29/029.
 */
class ResultModel{

    fun getData(name:String,start:Int):Flowable<Hotbean>{
        val ser= RetrofitUtils.instance.getApiService(API.url, ApiService::class.java)
        val ober=ser.getSearchData(10,name,start)
        return ober
    }
}