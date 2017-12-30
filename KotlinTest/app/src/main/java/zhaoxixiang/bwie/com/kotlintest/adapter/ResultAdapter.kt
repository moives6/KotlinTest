package zhaoxixiang.bwie.com.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.result_item.*
import zhaoxixiang.bwie.com.kotlintest.Model.bean.bean.Hotbean
import zhaoxixiang.bwie.com.kotlintest.R

/**
 * Created by admin on 2017/12/29/029.
 */
class ResultAdapter(var context: Context,var list:ArrayList<Hotbean.ItemListBean.DataBean>):RecyclerView.Adapter<ResultAdapter.MyViewHolder>(){


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.result_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        if (holder != null) {
            holder.name.setText(list.get(position).title)
            holder.type.setText(list.get(position).category)
            holder.sdv.setImageURI(list.get(position).cover!!.feed)
        }
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var name:TextView=itemView.findViewById(R.id.result_item_name)as TextView
        var type:TextView=itemView.findViewById(R.id.result_item_type)as TextView

        var sdv:SimpleDraweeView=itemView.findViewById(R.id.result_item_sdv)as SimpleDraweeView
        var ll:LinearLayout=itemView.findViewById(R.id.result_item_ll)as LinearLayout
    }
}