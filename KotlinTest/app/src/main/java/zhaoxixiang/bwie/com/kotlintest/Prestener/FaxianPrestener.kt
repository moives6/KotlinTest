package zhaoxixiang.bwie.com.kotlintest.Prestener

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import zhaoxixiang.bwie.com.kotlintest.Model.bean.FaxianModel
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.FindBean
import zhaoxixiang.bwie.com.kotlintest.View.FaxianView

/**
 * Created by admin on 2017/12/28/028.
 */
class FaxianPrestener(faxianView:FaxianView){
    val model:FaxianModel?= FaxianModel()

    val faxianView:FaxianView?=faxianView
    //p跟m关联
    fun pm(){
        val obser=model!!.getData()

        obser.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableSubscriber<List<FindBean>>() {

                    override fun onComplete() {

                    }

                    override fun onError(t: Throwable?) {

                    }

                    override fun onNext(t: List<FindBean>?) {
                        faxianView!!.showData(t!!)
                    }
                })
    }
}

