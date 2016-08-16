package com.example.xianghaapp.adapter.holder;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/10.
 */
public class BaseViewHolder {

    private View  converView;
    private SparseArray<View> sparseArray=new SparseArray<>();

    public BaseViewHolder(Context context, @LayoutRes int id) {

         converView = LayoutInflater.from(context).inflate(id, null);//加载布局
         converView.setTag(this);

    }
    public static  BaseViewHolder getViewHolder(View view,Context context,@LayoutRes  int id){
           //获取holder对象
        BaseViewHolder baseViewHolder=null;
        if (view==null){
            baseViewHolder=new BaseViewHolder(context,id);
        }else{
            baseViewHolder= (BaseViewHolder) view.getTag();
        }
        return baseViewHolder;
    }
      public void  setText(String msg, int id){

          TextView tv= (TextView) findView(id);
            tv.setText(msg);
      }
      public View findView(@IdRes  int id){
          View view = sparseArray.get(id);
          if (view == null) {
              view = converView.findViewById(id);
              sparseArray.put(id, view);
          }
          return view;
      }
    public View getBaseViewHolder() {
        return converView;
    }
}
