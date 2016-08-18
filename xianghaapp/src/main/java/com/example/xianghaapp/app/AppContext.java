package com.example.xianghaapp.app;

import android.app.Application;
import android.content.Context;

import com.example.xianghaapp.util.SqliteUtil;

/**
 * Created by Administrator on 2016/8/15.
 */
public class AppContext extends Application{
    public static Context contex;
    public static SqliteUtil  sqliteUtil;
    @Override
    public void onCreate() {
        super.onCreate();
        contex=this;
        sqliteUtil=new SqliteUtil(this);
    }
}
