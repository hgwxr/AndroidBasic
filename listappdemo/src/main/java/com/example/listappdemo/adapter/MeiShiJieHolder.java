package com.example.listappdemo.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/9.
 */
public class MeiShiJieHolder {
    private View mConverView;
    private SparseArray<View> sparseArray = new SparseArray<>();

    public MeiShiJieHolder(Context context, @LayoutRes int id) {
        mConverView = LayoutInflater.from(context).inflate(id, null);//加载布局
        mConverView.setTag(this);//设置 tag 为 this
    }

    public static MeiShiJieHolder getHolder(View convertView, Context context, @LayoutRes int id) {

        //获取 holder 对象
        MeiShiJieHolder meiShiJieHolder = null;
        if (convertView == null) {
            meiShiJieHolder = new MeiShiJieHolder(context, id);
        } else {
            meiShiJieHolder = (MeiShiJieHolder) convertView.getTag();
        }
        return meiShiJieHolder;
    }

    public View findView(@IdRes int id) {
        View view = sparseArray.get(id);
        if (view == null) {
            view = mConverView.findViewById(id);
            sparseArray.put(id, view);
        }
        return view;
    }

    public void setText(String text, int id) {
        TextView textView = (TextView) findView(id);
        textView.setText(text);
    }

    public View getmConverView() {
        return mConverView;
    }
}
