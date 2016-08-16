package com.example.listmultillayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class GridAdapter  extends BaseAdapter implements CompoundButton.OnCheckedChangeListener{
    private List<ChartBean>  list;

    public GridAdapter(List<ChartBean> list) {
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
    public View getView(int position, View view, ViewGroup parent) {

         ChartBean  cb=list.get(position);
        View inflate=null;
        //判断是否可以复用
        if(view==null){//不能复用的时候
             //inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left, null);
            inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_checked, null);
        }else{
            Log.e("自定义标签", "类名==GridAdapter" + "方法名==getView=====:" + "view 复用了");
            inflate=view;
        }
        //showMsg(cb, inflate);
        toastData(cb,inflate);
        return inflate;
    }

    private void toastData(ChartBean cb, View inflate) {
        TextView tv1= (TextView) inflate.findViewById(R.id.tv1);
        CheckBox checkBox= (CheckBox) inflate.findViewById(R.id.cb);
        checkBox.setChecked(false);
        tv1.setText(null);
        tv1.setText(cb.getMsg());
        checkBox.setOnCheckedChangeListener(this);//设置监听
    }

    private void showMsg(ChartBean cb, View inflate) {
       TextView right= (TextView) inflate.findViewById(R.id.right);
        right.setText(null);
        TextView left= (TextView) inflate.findViewById(R.id.left);
        left.setText(null);
        if(cb.getF()==0){
            //左边
            left.setText(cb.getMsg());
        }else{
            //右边
           right.setText(cb.getMsg());
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.e("自定义标签", "类名==GridAdapter" + "方法名==onCheckedChanged=====:" +b);
    }
}
