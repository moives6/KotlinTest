package zhaoxixiang.bwie.com.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.faxian_item.view.*
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.FindBean
import zhaoxixiang.bwie.com.kotlintest.R

/**
 * Created by admin on 2017/12/28/028.
 */
class FaxianAdapter(context: Context,list: List<FindBean>): RecyclerView.Adapter<FaxianAdapter.MyViewHolder>() {

    private var context:Context=context
    private var list: List<FindBean> = list
    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        if (holder != null) {

            holder.tv.text=list.get(position).name

            holder.tv.setText(list.get(position).name)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.faxian_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        var tv:TextView=itemView.findViewById(R.id.fx_item_tv) as TextView
        var sdv:SimpleDraweeView=itemView.findViewById(R.id.fx_item_sdv) as SimpleDraweeView
    }
}