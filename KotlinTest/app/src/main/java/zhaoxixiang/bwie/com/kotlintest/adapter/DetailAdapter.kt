package zhaoxixiang.bwie.com.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.detail_item.*
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.FindBean
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.R

/**
 * Created by admin on 2017/12/28/028.
 */
class DetailAdapter(var context: Context,var list: ArrayList<Hotbean.ItemListBean.DataBean>): RecyclerView.Adapter<DetailAdapter.MyViewHolder>() {

    //自定义接口点击事件
    interface OnItemClick{
        fun onItemClick(position: Int)
    }

    var listener:OnItemClick?=null
    fun setOnClick(listener:OnItemClick){
        this.listener=listener
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        if (holder != null) {
            holder.tv.setText(list.get(position).title)
            holder.sdv.setImageURI(list.get(position).cover?.feed)
            holder.rl.setOnClickListener {
                listener!!.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.detail_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var tv:TextView=itemView.findViewById(R.id.detail_item_tv) as TextView
        var sdv:SimpleDraweeView=itemView.findViewById(R.id.detail_item_sdv) as SimpleDraweeView
        var rl:RelativeLayout=itemView.findViewById(R.id.detail_item_rl)as RelativeLayout
    }
}