package com.example.xianghaapp.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/8/15.
 */
public class AppContext extends Application{
    public static Context contex;

    @Override
    public void onCreate() {
        super.onCreate();
        contex=this;
    }
}
