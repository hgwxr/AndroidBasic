package com.example.asyncdemo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/8/8.
 */
public abstract    class Jsontask<T>  implements  MyBaseTask.HandlData {


    @Override
    public void handlData(byte[] bs) {
           String s=new String(bs);
        Gson gson=new Gson();
        Type type= new TypeToken<T>(){}.getType();
          T t= gson.fromJson(s,type);
           showData(t);
    }
    public   abstract  void   showData(T t);
}
