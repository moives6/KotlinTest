package zhaoxixiang.bwie.com.kotlintest.Prestener

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import zhaoxixiang.bwie.com.kotlintest.Model.bean.DetailModel
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.View.FaxianDetailView

/**
 * Created by admin on 2017/12/28/028.
 */
class FaxianDetailPresenter(view:FaxianDetailView){

    val model:DetailModel?= DetailModel()

    val view:FaxianDetailView?=view

    //p跟m关联
    fun pm(name:String){
        val flow= model!!.getData(name)

        flow.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableSubscriber<Hotbean>() {
                    override fun onComplete() {

                    }

                    override fun onError(t: Throwable?) {

                    }

                    override fun onNext(t: Hotbean?) {
                        view!!.showData(t!!)
                    }

                })
    }

}