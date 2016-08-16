package com.example.listappdemo.adapter;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public abstract class MeiShiJieBaseAdapter<T>   extends BaseAdapter {
    private List<T> list;
    @LayoutRes
    private int id;

    public MeiShiJieBaseAdapter(int id, List<T> list) {
        this.id = id;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MeiShiJieHolder meiShiJieHolder = MeiShiJieHolder.getHolder(convertView,parent.getContext(),id);//根据是否可以复用来决定是否创建 holder
        //设置内容
        fillData(meiShiJieHolder,position);// 填充内容,抽象方法,由具体子类实现自己的填充内容方式
        return meiShiJieHolder.getmConverView();
    }

    public abstract void fillData(MeiShiJieHolder myHolder,int position);
}
