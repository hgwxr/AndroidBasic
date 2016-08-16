package com.example.listpartrefresh.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.RawRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public abstract class DiyAdapter<T>  extends BaseAdapter {
    private List<T> list;
    @LayoutRes
    private int id;
    public DiyAdapter(List<T> list,int id) {
        this.list = list;
        this.id=id;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        ViewHolder  viewHolder=ViewHolder.getViewHolder(view,parent,id);
            fillData(viewHolder,i);

        return viewHolder.getView();
    }
  public abstract  void fillData(ViewHolder  viewHolder,int position);


}
