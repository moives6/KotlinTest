package zhaoxixiang.bwie.com.kotlintest.Prestener

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import zhaoxixiang.bwie.com.kotlintest.Model.bean.ResultModel
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.View.ResultView

/**
 * Created by admin on 2017/12/29/029.
 */
class ResultPresenter(view:ResultView){
    val model:ResultModel= ResultModel()
    val view:ResultView=view

    fun getData(name:String,start:Int){
        val flow=model.getData(name,start)

        flow.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableSubscriber<Hotbean>(){
                    override fun onNext(t: Hotbean?) {
                        if (t != null) {
                            view.showData(t)
                        }
                    }

                    override fun onComplete() {

                    }

                    override fun onError(t: Throwable?) {

                    }

                })
    }
}