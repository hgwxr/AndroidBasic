package com.example.xianghaapp.util;



import com.example.xianghaapp.model.bean.JsonRootBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class JsonToBean {



    public  static <T> T getBeanJson(String json,Type type){

        Gson gson=new Gson();
       // Type type=new TypeToken<T>(){}.getType();
        T t= gson.fromJson(json,type);

        return t;
        }
}
