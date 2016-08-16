package com.example.mvphelloworld.model;

import com.example.mvphelloworld.util.UtilAsync;

/**
 * Created by Administrator on 2016/8/10.
 */
public class MainActivityModel implements BaseModel{
    @Override
    public void loadData(OnLoadCompleteListener onLoadCompleteListener, String path) {

          //启用async task  执行耗时操作
             new UtilAsync(onLoadCompleteListener).execute(path);

    }
}
