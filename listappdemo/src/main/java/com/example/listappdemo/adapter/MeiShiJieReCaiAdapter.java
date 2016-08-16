package com.example.listappdemo.adapter;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.example.listappdemo.Bean.Data;
import com.example.listappdemo.R;
import com.example.listappdemo.task.MeiShiJieReCaiTask;
import com.example.listappdemo.task.MeiShiReCaiCallBack;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class MeiShiJieReCaiAdapter extends MeiShiJieBaseAdapter<Data>  {

    private List<Data>  list;
    public MeiShiJieReCaiAdapter(int id, List<Data> list) {
        super(id, list);
        this.list=list;
    }

    @Override
    public void fillData(MeiShiJieHolder holder, int position) {
        Data data = list.get(position);

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
        MeiShiReCaiCallBack myBitMapCallBack = new MeiShiReCaiCallBack(imageView);
        MeiShiJieReCaiTask myAsyncTask = new MeiShiJieReCaiTask(myBitMapCallBack);
        myAsyncTask.execute(data.getTitlepic());
    }


}
