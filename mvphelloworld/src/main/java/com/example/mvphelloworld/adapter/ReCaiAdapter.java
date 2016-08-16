package com.example.mvphelloworld.adapter;

import android.widget.ImageView;
import android.widget.RatingBar;

import com.example.mvphelloworld.R;
import com.example.mvphelloworld.adapter.holder.BaseViewHolder;
import com.example.mvphelloworld.model.bean.Data;
import com.example.mvphelloworld.util.BitMapCallBack;
import com.example.mvphelloworld.util.UtilAsync;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class ReCaiAdapter  extends ReCaiBaseAdapter {
    private  List<Data>  list;
    public ReCaiAdapter(int id, List<Data> list) {
        super(id, list);
        this.list=list;
    }

    @Override
    public void fillData(BaseViewHolder holder, int position) {
         Data  data=list.get(position);
        //填数据
        //给填充数据
        holder.setText(data.getTitle()+ "", R.id.name);
        RatingBar rb = (RatingBar) holder.findView(R.id.rb);
        // rb.setNumStars(data.getRate());
        rb.setRating((float)data.getRate());
        holder.setText(data.getKouwei()+"/"+data.getGongyi(),R.id.kouwei);
        holder.setText(data.getStep()+"/"+data.getMt(),R.id.juli);
        ImageView imageView = (ImageView) holder.findView(R.id.iv);
        imageView.setImageBitmap(null);
        imageView.setTag(data.getTitlepic());
        BitMapCallBack bitMapCallBack = new BitMapCallBack(imageView);
        UtilAsync utilAsync = new UtilAsync(bitMapCallBack);
        utilAsync.execute(data.getTitlepic());

    }
}
