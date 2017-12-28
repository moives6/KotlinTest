package zhaoxixiang.bwie.com.kotlintest.Prestener

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import zhaoxixiang.bwie.com.kotlintest.Model.bean.HotModelse
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.View.ShowHotView

/**
 * Created by 胡靖宇 on 2017/12/28.
 */
class HotprestenerSE(showView: ShowHotView){

    val  hotmodel:HotModelse?=HotModelse()
    val hotView:ShowHotView?=showView

    fun pAndm(){
        val flowable=hotmodel!!.getHotData()

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<Hotbean>(){
                    override fun onNext(t: Hotbean?) {
                        hotView!!.ShowHotData(t!!)
                    }

                    override fun onComplete() {

                    }

                    override fun onError(t: Throwable?) {

                    }

                })
    }

    fun mpAndm(){
        val flowable=hotmodel!!.getHotmData()

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<Hotbean>(){
                    override fun onNext(t: Hotbean?) {
                        hotView!!.ShowHotData(t!!)
                    }

                    override fun onComplete() {

                    }

                    override fun onError(t: Throwable?) {

                    }

                })
    }

}