package com.example.xianghaapp.presenter;

import android.database.sqlite.SQLiteDatabase;

import com.example.xianghaapp.app.AppContext;
import com.example.xianghaapp.model.LiveCookModel;
import com.example.xianghaapp.model.base.BaseModel;
import com.example.xianghaapp.model.bean.Data;
import com.example.xianghaapp.model.bean.JsonRootBean;
import com.example.xianghaapp.model.bean.learncookheader.Item_head;
import com.example.xianghaapp.presenter.base.BasePresenter;
import com.example.xianghaapp.util.JsonToBean;
import com.example.xianghaapp.view.base.BaseView;
import com.example.xianghaapp.view.fragment.LearnCook;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public class LiveCookPresenter extends BasePresenter {


    public LiveCookPresenter(BaseView baseView) {
        super(baseView);
        baseModel = new LiveCookModel();
    }

    public void loadData(final String path, final int flag) {

        baseModel.loadData(new BaseModel.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(byte[] bs, String PATH) {

                //判断 byte数组中是否为空   网络故障byte数组为空
                if (bs == null) {
                    //从缓存中查看是否有缓存，有 取出缓存，没有 过
                    SQLiteDatabase writableDatabase = AppContext.sqliteUtil.getWritableDatabase();
                    //取出一条


                    return;
                }
                if (bs != null) {
                    //直接缓存数据，  插入数据时若过已存在在返回-1，  在调用update更新该条数据
                    deliverData(bs, flag);

                }
            }
        }, path);


    }

    private void deliverData(byte[] bs, int flag) {
        if (flag == 0) {
            JsonRootBean beanJson = JsonToBean.getBeanJson(new String(bs), new TypeToken<JsonRootBean>() {
            }.getType());
            baseView.showData(beanJson.getData());
        } else if (flag == 1) {
//                        Item_head.DataBean.TopicBean beanJson = JsonToBean.getBeanJson(new String(bs), new TypeToken<Item_head.DataBean.TopicBean>() {
//                        }.getType());
            Item_head item_head = new Gson().fromJson(new String((bs)), Item_head.class);
            baseView.showHeader(item_head);
        }
    }
}
