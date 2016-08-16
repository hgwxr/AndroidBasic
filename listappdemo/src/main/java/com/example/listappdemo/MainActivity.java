package com.example.listappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listappdemo.Bean.Data;
import com.example.listappdemo.Bean.RootBean;
import com.example.listappdemo.adapter.MeiShiJieReCaiAdapter;
import com.example.listappdemo.task.MeiShiJieReCaiTask;
import com.example.listappdemo.util.JsonToBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener{

    private ListView lv;
    private List<Data> dataList;
    private boolean isCanLoadMore = false;
    private boolean isLoading = false;
    private static int page=0;
    private String PATH = "http://api102.meishi.cc/v5/class_list1.php?lon=&source=android&cid=6&vk=2417a0052eac5cd81d5dce4d168a3973&sort_sc=asc&sort=default&lat=&bcid=13&format=json&page=" + page;
   private MeiShiJieReCaiAdapter meiShiJieReCaiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        new MeiShiJieReCaiTask(new MeiShiJieReCaiTask.DealByte() {
            @Override
            public void dealByte(byte[] bs, String requestPath) {
                //获取list
                RootBean rootBean = JsonToBean.getBeanJson(new String(bs));
                dataList = rootBean.getObj().getData();
                //设置适配器
                meiShiJieReCaiAdapter=new MeiShiJieReCaiAdapter(R.layout.item_recai,dataList);
                lv.setAdapter(meiShiJieReCaiAdapter);

            }


        }).execute(PATH);
        lv.setOnScrollListener(this);//设置滑动

    }

    /**
     * 滑动状态变化
     * @param view
     * @param scrollState 1 SCROLL_STATE_TOUCH_SCROLL是拖动   2 SCROLL_STATE_FLING是惯性滑动  0SCROLL_STATE_IDLE是停止 , 只有当在不同状态间切换的时候才会执行
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // Log.e("自定义标签", "onScrollStateChanged() called with: " + "view = [" + view + "], scrollState = [" + scrollState + "]");
        if (isCanLoadMore && scrollState == SCROLL_STATE_IDLE&&!isLoading) {
            Toast.makeText(this, "正在拼命加载中.....", Toast.LENGTH_SHORT).show();
            isCanLoadMore = false;
            isLoading = true;//应该在网络请求结束(包括异常)后 修改为 false

            new MeiShiJieReCaiTask(new MeiShiJieReCaiTask.DealByte() {
                @Override
                public void dealByte(byte[] bs, String requestPath) {
                    //获取list
                    RootBean rootBean = JsonToBean.getBeanJson(new String(bs));

                    dataList.addAll(rootBean.getObj().getData());//将老的数据源加载新的数据源
                    //设置新数据源
                    isLoading = false;//应该在网络请求结束(包括异常)后 修改为 false

                    page++;
                }


            }).execute(PATH);

            //设置适配器
            meiShiJieReCaiAdapter=new MeiShiJieReCaiAdapter(R.layout.item_recai,dataList);
          //  lv.setAdapter(meiShiJieReCaiAdapter);

//            list.addAll(list1);
            meiShiJieReCaiAdapter.notifyDataSetChanged();//刷新界面
            isLoading = false;
        }
    }

    /**
     *
     * @param view listview
     * @param firstVisibleItem 第一个可见的 item 的索引
     * @param visibleItemCount 可以显示的 item的条数
     * @param totalItemCount 总共有多少个 item
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount == totalItemCount) {//代表最后一条出来了,仅仅是代表出来了,需要判断最后一条距离父控件顶部的距离
            View childAt = view.getChildAt(visibleItemCount - 1);//getchildat 只获取屏幕内可见的 item
//            Log.e("自定义标签", "类名==MainActivity" + "方法名==onScroll=====:" + childAt);
            if (!isLoading&&childAt != null && childAt.getBottom() <= view.getHeight()) {//如果最后一条的底部距离 listview的顶部 小于等于 listview 高度,代表最后一条完全出现在 listview 内部
                isCanLoadMore = true;//可以加载了

            }
            if(isLoading){
                    Toast.makeText(this, "网速太差拼命加载中.....", Toast.LENGTH_SHORT).show();
            }
        }
//        Log.e("自定义标签", "onScroll() called with: " + "view = [" + view + "], firstVisibleItem = [" + firstVisibleItem + "], visibleItemCount = [" + visibleItemCount + "], totalItemCount = [" + totalItemCount + "]");
    }
    //分页
}
