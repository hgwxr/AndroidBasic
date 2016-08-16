package com.example.mvphelloworld.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mvphelloworld.R;
import com.example.mvphelloworld.adapter.ReCaiAdapter;
import com.example.mvphelloworld.model.bean.Data;
import com.example.mvphelloworld.presenter.BasePresenter;
import com.example.mvphelloworld.util.ToastUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  BaseView<List<Data>> ,  AbsListView.OnScrollListener{

    private ListView lv;
    private  String PATH="http://api102.meishi.cc/v5/class_list1.php?lon=&source=android&cid=6&vk=2417a0052eac5cd81d5dce4d168a3973&sort_sc=asc&sort=default&lat=&page=%d&bcid=13&format=json";
    private    int page=1;
    private boolean isCanLoadMore = false;
    private boolean isLoading = false;
    private List<Data>  dataList;
    private ReCaiAdapter reCaiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page=1;
         lv = (ListView) findViewById(R.id.lv);
        //通过presenter  获取数据
        new BasePresenter(this).loadData(String.format(PATH,page));
        lv.setOnScrollListener(this);
    }
    @Override
    public void showData(List<Data> list) {


        isLoading=false;

        if(page==1) {
            dataList=list;
            reCaiAdapter = new ReCaiAdapter(R.layout.item_recai, dataList);
            lv.setAdapter(reCaiAdapter);
        }else{
             //dataList.addAll(0,list);//会刷新到顶部,去掉原来的list里 的数据
            //reCaiAdapter = new ReCaiAdapter(R.layout.item_recai, list);
          //  dataList.addAll(list);
            //lv.setSelection(dataList.size());
            dataList.addAll(list);
            //lv.setAdapter(reCaiAdapter);
            reCaiAdapter.notifyDataSetChanged();
        }
        page++;
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {

        if (isCanLoadMore&&scrollState==SCROLL_STATE_IDLE){
            isCanLoadMore=false;
            isLoading=true;
            ToastUtil.showToast(this,"正在拼命加载中.....");
            new BasePresenter(this).loadData(String.format(PATH,page));


        }
    }

    @Override
    public void onScroll(AbsListView absListView,int firstVisibleItem, int visibleItemCount, int totalItemCount) {
           if(firstVisibleItem+visibleItemCount==totalItemCount){
              //最后一条出来了
               View childAt = absListView.getChildAt(visibleItemCount - 1);
               if (childAt!=null&&childAt.getBottom()<=absListView.getHeight()){
                       //表示最后一条已到低
                   if (!isLoading){
                   isCanLoadMore=true;
                   }else{
                       ToastUtil.showToast(this,"网络太差,正在拼命加载中.....");
                   }
               }
           }
    }
}
