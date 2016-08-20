package com.example.xianghaapp.view.fragment;


import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.xianghaapp.R;
import com.example.xianghaapp.adapter.LearnCookAdapter;
import com.example.xianghaapp.app.AppContext;
import com.example.xianghaapp.model.bean.Data;
import com.example.xianghaapp.model.bean.learncookheader.Item_head;
import com.example.xianghaapp.presenter.LiveCookPresenter;
import com.example.xianghaapp.util.BitMapCallBack;
import com.example.xianghaapp.util.GlobalPath;
import com.example.xianghaapp.util.ShowView;
import com.example.xianghaapp.util.ToastUtil;
import com.example.xianghaapp.util.UtilAsync;
import com.example.xianghaapp.view.base.BaseView;
import com.example.xianghaapp.view.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wl
 */
public class LearnCook extends BaseFragment<LiveCookPresenter> implements BaseView<List<Data>, Item_head>, AbsListView.OnScrollListener {

    private ListView listView;
    private LearnCookAdapter learnCookAdapter;
    private List<Data> dataList = new ArrayList<>();
    private boolean isCanLoadMore;
    private boolean isLoading;
    private int page = 1;
    private int flag;
    private View viewHeader;
    private View hotView;
    private View view;
    private GridView gridView;
    private Boolean c = false;
    private  SharedPreferences noPic;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.item_learn_cook, container, false);
        viewHeader = inflater.inflate(R.layout.item_learn_cook_header, null);

        //获取header数据
        gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.setVisibility(View.GONE);
        listView = ((ListView) view.findViewById(R.id.listView));
        listView.addHeaderView(viewHeader);
        new LiveCookPresenter(this).loadData(GlobalPath.SHOUYE_QITASHUJU, flag = 1);
        new LiveCookPresenter(this).loadData(GlobalPath.SHOUYE_JINGCAISHENGHUO + page, flag = 0);

        listView.setOnScrollListener(this);
        registerForContextMenu(listView);
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Log.e("自定义标签", "类名==LearnCook" + "方法名==onItemLongClick=====:" + position+"=="+id);
//                return false;
//            }
//        });
        return view;
    }

    @Override
    public LiveCookPresenter getBasePresenter() {
        return new LiveCookPresenter(this);
    }

    @Override
    public void showData(List<Data> list) {

        isLoading = false;

        if (page == 1) {
            dataList = list;
            learnCookAdapter = new LearnCookAdapter(R.layout.live_area, dataList, flag, null);
            listView.setAdapter(learnCookAdapter);
            gridView.setAdapter(learnCookAdapter);
        } else {

            dataList.addAll(list);
            gridView.setAdapter(learnCookAdapter);
            learnCookAdapter.notifyDataSetChanged();
        }
        page++;
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void showHeader(Item_head item_head) {
        //香哈头条
        int[] headerIds = new int[]{R.id.header1, R.id.header2};
        List<Item_head.DataBean.NousBean> nous = item_head.getData().getNous();
        for (int i = 0; i < nous.size(); i++) {

            View viewById = viewHeader.findViewById(headerIds[i]);
            TextView descHeader = (TextView) viewById.findViewById(R.id.descHeader);
            //showTextView(descHeader,nous.get(i).getTitle());
            TextView categoryHeader = (TextView) viewById.findViewById(R.id.categoryHeader);
            TextView countCommentXiangHaHeader = (TextView) viewById.findViewById(R.id.countCommentXiangHaHeader);
            TextView countXiangHaHeader = (TextView) viewById.findViewById(R.id.countXiangHaHeader);
            ImageView picHeader = (ImageView) viewById.findViewById(R.id.picHeader);
            descHeader.setText(nous.get(i).getTitle());
            ShowView.showTextView(descHeader, nous.get(i).getTitle());
            ShowView.showTextView(categoryHeader, nous.get(i).getClassifyname());
            ShowView.showTextView(countCommentXiangHaHeader, nous.get(i).getAllClick() + "浏览");
            ShowView.showTextView(countXiangHaHeader, nous.get(i).getCommentCount() + "评论");
            ShowView.showTextView(picHeader, nous.get(i).getImg());
        }


        //人气美食家


        List<Item_head.DataBean.ActiveUserBean> activeuser = item_head.getData().getActiveUser();
        ArrayList<View> viewsChilds = new ArrayList<>();
        int[] ids = new int[]{R.id.user1, R.id.user2, R.id.user3, R.id.user4, R.id.user5, R.id.user6, R.id.user7, R.id.user8, R.id.user9, R.id.user10};
        for (int i = 0; i < activeuser.size(); i++) {

            View viewById = viewHeader.findViewById(ids[i]);

            showHotUser(activeuser, i, viewById);
            //viewsChilds.add(viewById);
            //linearLayout.addView(viewById);
            // linearLayout.addView(viewById);

        }
        //linearLayout.addChildrenForAccessibility(viewsChilds);


        //精选专题
        List<Item_head.DataBean.TopicBean> topics = item_head.getData().getTopic();

        for (int i = 0; i < topics.size(); i++) {
            switch (i) {
                case 0:
                    ((TextView) viewHeader.findViewById(R.id.topPart1).findViewById(R.id.jingxuanDesc)).setText(topics.get(i).getTitle());
                    ((TextView) viewHeader.findViewById(R.id.topPart1).findViewById(R.id.jingxuanCount)).setText(topics.get(i).getSubtitle());
                    ImageView headerPic = (ImageView) viewHeader.findViewById(R.id.topPart1).findViewById(R.id.jingxuanPic);
                    headerPic.setTag(topics.get(i).getImgs());
                    headerPic.setImageBitmap(null);
                    getPic(topics.get(i).getImgs(), headerPic);
                    break;
                case 1:
                    ((TextView) viewHeader.findViewById(R.id.topPart2).findViewById(R.id.jingxuanDesc)).setText(topics.get(i).getTitle());
                    ((TextView) viewHeader.findViewById(R.id.topPart2).findViewById(R.id.jingxuanCount)).setText(topics.get(i).getSubtitle());
                    ImageView headerPic1 = (ImageView) viewHeader.findViewById(R.id.topPart2).findViewById(R.id.jingxuanPic);
                    headerPic1.setTag(topics.get(i).getImgs());
                    headerPic1.setImageBitmap(null);
                    getPic(topics.get(i).getImgs(), headerPic1);
                    break;
                case 2:
                    ((TextView) viewHeader.findViewById(R.id.topPart3).findViewById(R.id.jingxuanDesc)).setText(topics.get(i).getTitle());
                    ((TextView) viewHeader.findViewById(R.id.topPart3).findViewById(R.id.jingxuanCount)).setText(topics.get(i).getSubtitle());
                    ImageView headerPic2 = (ImageView) viewHeader.findViewById(R.id.topPart3).findViewById(R.id.jingxuanPic);
                    headerPic2.setTag(topics.get(i).getImgs());
                    headerPic2.setImageBitmap(null);
                    getPic(topics.get(i).getImgs(), headerPic2);
                    break;
            }

        }

    }


    private void showHotUser(List<Item_head.DataBean.ActiveUserBean> activeuser, int i, View viewById) {
        ImageView hotUser = (ImageView) viewById.findViewById(R.id.hotUser);
        TextView userName = (TextView) viewById.findViewById(R.id.userName);
        userName.setText(activeuser.get(i).getNickName());
        hotUser.setTag(activeuser.get(i).getImg());
        hotUser.setImageBitmap(null);
        ShowView.getPic(activeuser.get(i).getImg(), hotUser);
    }

    private void getPic(String pic, ImageView headerPic) {
        BitMapCallBack bitMapCallBack = new BitMapCallBack(headerPic);
        UtilAsync utilAsync = new UtilAsync(bitMapCallBack);
        utilAsync.execute(pic);
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {

        if (isCanLoadMore && scrollState == SCROLL_STATE_IDLE) {
            isCanLoadMore = false;
            isLoading = true;
            ToastUtil.showToast(getContext(), "正在拼命加载中.....");
            new LiveCookPresenter(this).loadData(GlobalPath.SHOUYE_JINGCAISHENGHUO + page, flag = 0);


        }
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount == totalItemCount) {
            //最后一条出来了
            View childAt = absListView.getChildAt(visibleItemCount - 1);
            if (childAt != null && childAt.getBottom() <= absListView.getHeight()) {
                //表示最后一条已到低
                if (!isLoading) {
                    isCanLoadMore = true;
                } else {
                    ToastUtil.showToast(getContext(), "网络太差,正在拼命加载中.....");
                }
            }
        } else if (firstVisibleItem == visibleItemCount) {

        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       // getActivity().getMenuInflater().inflate(R.menu.item_menu_part2, menu);
        inflater.inflate(R.menu.item_menu_part2, menu);
        MenuItem menuItem = menu.findItem(R.id.nopic);
        menuItem.setChecked(UtilAsync.isSharePreference());
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notMenu:
                break;
            case R.id.changeMenu:
                break;
            case R.id.nopic:
                item.setChecked(!item.isChecked());
                SharedPreferences sp = AppContext.contex.getSharedPreferences("noPic", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("isNoPic", item.isChecked()).apply();
                //learnCookAdapter.notifyDataSetChanged();
                break;
        }
        // changeView();
        // createListDialog();
        //createProgressDialog();
        //createTimeDialog();
        //  createDateDialog();
        // createSelfDialog();


        return super.onOptionsItemSelected(item);
    }

    private void changeView() {

        if (!c) {
            //GridView
            listView.setVisibility(View.GONE);
            gridView.setVisibility(View.VISIBLE);
        } else {
            //ListView
            gridView.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }
        c = !c;
    }


    private void createSelfDialog() {

        AlertDialog.Builder selfDialog = new AlertDialog.Builder(getActivity());
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        TextView textView = new TextView(getContext());
        textView.setText("这是标题");
        //   textView.setRight(View.FOCUS_RIGHT);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);
        textView.setLayoutParams(lp);
        relativeLayout.addView(textView);
        selfDialog.setView(relativeLayout);
        AlertDialog alertDialog = selfDialog.create();
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    private void createDateDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dat) {
                Log.e("自定义标签", "onDateSet() called with: " + "datePicker = [" + datePicker + "], year = [" + year + "], month = [" + month + "], dat = [" + dat + "]");
            }
        }, 1999, 2, 3);
        datePickerDialog.show();
    }

    private void createTimeDialog() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

            }
        }, 23, 59, true);
        timePickerDialog.show();

    }

    private void createProgressDialog() {

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("这是标题");
        progressDialog.setMax(100);
        progressDialog.setTitle("正在加载中......");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setProgress(30);


    }

    private void createListDialog() {
        AlertDialog.Builder listDialog = new AlertDialog.Builder(getContext());
        listDialog.setTitle("listDialog列表对话框");
        listDialog.setIcon(R.mipmap.ic_launcher);
        listDialog.setItems(new String[]{"1,xxxxx选项", "2,xxxxx选项", "3,xxxxx选项", "4,xxxxx选项", "5,xxxxx选项"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {//which  第几个item
                ToastUtil.showToast(getActivity(), "listdialog被点击了");
            }
        });
        listDialog.setCancelable(false);
        listDialog.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.item_menu_longpress, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ToastUtil.showToast(getActivity(), "被点击了" + item.getTitle());
        createListDialog();
        return super.onContextItemSelected(item);
    }


}
