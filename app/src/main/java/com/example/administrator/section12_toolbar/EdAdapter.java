package com.example.administrator.section12_toolbar;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
//【1】让适配器继承RecyclerView.Adapter，并将泛型指定为EdAdapter.ViewHolder
    //其中ViewHolder是EdAdapter的一个内部类
public class EdAdapter extends RecyclerView.Adapter<EdAdapter.ViewHolder>{
    private List<Eddie>mlist;
    public EdAdapter(List<Eddie>mlist){
        this.mlist=mlist;
    }
    //【2】首先定义了一个内部类ViewHolder，ViewHolder要继承RecyclerView.ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ed_image;
        TextView ed_text;
        CardView cardView;
        public ViewHolder(View itemView) {
            //itemView这个参数就是RecyclerView子项的最外层布局
            super(itemView);
            //通过findViewById()找到布局中的控件
            CardView cardView=(CardView)itemView;
            ed_image= (ImageView) itemView.findViewById(R.id.ed_image);
            ed_text= (TextView) itemView.findViewById(R.id.ed_text);

        }
    }

    //【3】onCreateViewHolder用于创建ViewHolder的实例，我们在这个方法中将ed_item布局加载进来，然后创建ViewHolder实例
    @Override
    public EdAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ed_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    //【3】onBindViewHolder用于对RecyclerView子项赋值，会在每个子项被滚动到屏幕的时候执行
    @Override
    public void onBindViewHolder(EdAdapter.ViewHolder holder, int position) {
        Eddie eddie=mlist.get(position);
        holder.ed_image.setImageResource(eddie.getImageId());
        holder.ed_text.setText(eddie.getName());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

}
