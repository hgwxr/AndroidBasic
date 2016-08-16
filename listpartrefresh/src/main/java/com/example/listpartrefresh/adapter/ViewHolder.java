package com.example.listpartrefresh.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/8/11.
 */
public class ViewHolder {

    private View view;
    private SparseArray<View>  sparseArray=new SparseArray<>();

    public ViewHolder(Context contex,@LayoutRes int id ) {

        view= LayoutInflater.from(contex).inflate(id,null);
        view.setTag(this);
    }
    public static  ViewHolder  getViewHolder(View view, ViewGroup parent,@LayoutRes int id){
             ViewHolder  viewHolder=null;
          if (view==null){
              viewHolder=new ViewHolder(parent.getContext(),id);
          }else{
              viewHolder= (ViewHolder) view.getTag();
          }

        return viewHolder;
    }
    public View findView(@IdRes int id ){

        View  rView=sparseArray.get(id);
        if (rView==null){
            rView=view.findViewById(id);
            sparseArray.put(id,rView);
        }
          return rView;
    }

    public View getView() {
        return view;
    }
}
