package zhaoxixiang.bwie.com.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.R

/**
 * Created by 胡靖宇 on 2017/12/26.
 */
class HotAdapter(var con: Context, var mlist: Hotbean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() , View.OnClickListener{

    private var mOnItemClickListener: OnItemClickListener? = null



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

       var mv=Myview(holder?.itemView)
        mv.title.setText(mlist.itemList!!.get(position).data!!.title.toString())
        mv.time.setText(mlist.itemList!!.get(position).data!!.category.toString()+"/")
        mv.img.setImageURI(mlist.itemList!!.get(position).data!!.cover!!.detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        var view=LayoutInflater.from(con).inflate(R.layout.hotitem,parent,false)
        view?.setOnClickListener(this);
        return Myview(view)

    }

    override fun getItemCount(): Int{
        return mlist.itemList!!.size
    }

    class Myview(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var time: TextView = itemView!!.findViewById(R.id.tv_time) as TextView
        var title: TextView = itemView!!.findViewById(R.id.tv_title) as TextView
        var img: SimpleDraweeView = itemView!!.findViewById(R.id.iv_photo) as SimpleDraweeView

    }

    override fun onClick(p0: View?) {

        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener!!.onItemClick(p0!!,p0.getTag() as Int)
        }
    }

    //点击事件
    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)

    }

    //最后暴露给外面的调用者，定义一个设置Listener的方法
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mOnItemClickListener = listener
    }


}