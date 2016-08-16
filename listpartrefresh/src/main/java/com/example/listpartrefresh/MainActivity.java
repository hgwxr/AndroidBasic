package com.example.listpartrefresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.listpartrefresh.adapter.DiyAdapterImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    private ListView lv;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= ((ListView) findViewById(R.id.lv));
        //准备list
        list=new ArrayList<>();
        for (int i = 0; i < 50; i++) {
           list.add("list元素，"+i);
        }
        //准备适配器
        DiyAdapterImpl diyAdapter = new DiyAdapterImpl(list, R.layout.item_list);
         lv.setAdapter(diyAdapter);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        View  viewTag=lv.findViewWithTag("lvtag"+position);
        if (viewTag!=null){
            String content="修改后数据";
            ((TextView) viewTag).setText(content);
            list.set(position,content);
        }
    }
}
