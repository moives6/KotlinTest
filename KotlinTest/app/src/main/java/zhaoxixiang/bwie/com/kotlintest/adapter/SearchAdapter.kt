package zhaoxixiang.bwie.com.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.search_item.*
import zhaoxixiang.bwie.com.kotlintest.R

/**
 * Created by admin on 2017/12/29/029.
 */
class SearchAdapter(var context: Context,var list: ArrayList<String>):RecyclerView.Adapter<SearchAdapter.MyViewHolder>(){

    //自定义接口点击事件
    interface OnItemClick{
        fun onItemClick(position: String)
    }

    var listener:OnItemClick?=null
    fun setOnClick(listener:OnItemClick){
        this.listener=listener
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        if (holder != null) {
            holder.tv.setText(list.get(position))
            holder.ll.setOnClickListener {
                listener!!.onItemClick(list.get(position))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.search_item,parent,false))
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var tv:TextView=itemView.findViewById(R.id.search_item_tv)as TextView
        var ll:LinearLayout=itemView.findViewById(R.id.search_item_ll) as LinearLayout
    }
}