package com.example.mvphelloworld.adapter;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mvphelloworld.adapter.holder.BaseViewHolder;
import com.example.mvphelloworld.model.bean.Data;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public abstract class ReCaiBaseAdapter extends BaseAdapter {

    private List<Data> list;
    @LayoutRes
    private int id;
    public ReCaiBaseAdapter(int id, List<Data> list) {
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

        BaseViewHolder  baseViewHolder=BaseViewHolder.getViewHolder(view,parent.getContext(),id);

        fillData(baseViewHolder,position);
        return baseViewHolder.getBaseViewHolder();
    }
 public  abstract  void fillData(BaseViewHolder bvh,int position);
}
