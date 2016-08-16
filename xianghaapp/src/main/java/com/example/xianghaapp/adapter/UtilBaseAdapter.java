package com.example.xianghaapp.adapter;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.xianghaapp.adapter.holder.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public abstract class UtilBaseAdapter<T> extends BaseAdapter {

    private List<T> list;
    @LayoutRes
    private int id;
    public UtilBaseAdapter(int id, List<T> list) {
        this.list = list;
        this.id=id;
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
        return  position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        BaseViewHolder baseViewHolder=BaseViewHolder.getViewHolder(view,parent.getContext(),id);

        fillData(baseViewHolder,position);
        return baseViewHolder.getBaseViewHolder();
    }
    public  abstract  void fillData(BaseViewHolder bvh,int position);
}
