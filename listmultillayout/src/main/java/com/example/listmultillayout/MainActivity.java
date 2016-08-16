package com.example.listmultillayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private List<ChartBean>  beanList;
    private GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         beanList=new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            double random = Math.random();
            int f=random>0.5? 1:0;//大于0.5 right ，小于0.5  left
            ChartBean  cb=new ChartBean("随机数据"+i,f);
            beanList.add(cb);
            cb=null;
        }
        gv = (GridView) findViewById(R.id.lv);
        GridAdapter ga=new GridAdapter(beanList);
        //通过适配器将数据放入view中
         gv.setAdapter(ga);
        gv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ToastUtil.showToast(this,i+"被点击了"+l);
    }
}
