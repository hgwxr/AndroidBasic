package com.example.listpartrefresh.adapter;

import android.view.View;
import android.widget.TextView;

import com.example.listpartrefresh.R;

import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class DiyAdapterImpl  extends DiyAdapter<String> {


    private List<String>  list;
    public DiyAdapterImpl(List<String> list, int id) {
        super(list, id);
        this.list=list;
    }

    @Override
    public void fillData(ViewHolder viewHolder, int position) {
       TextView   tv1 = (TextView) viewHolder.findView(R.id.tv1);
        tv1.setTag("lvtag"+position);
        tv1.setText(list.get(position));
    }
}
