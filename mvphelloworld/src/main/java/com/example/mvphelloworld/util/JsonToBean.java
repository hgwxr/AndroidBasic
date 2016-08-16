package com.example.mvphelloworld.util;


import com.example.mvphelloworld.model.bean.RootBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/8/9.
 */
public class JsonToBean {

    public static RootBean getBeanJson(String json){

        Gson gson=new Gson();
        Type type=new TypeToken<RootBean>(){}.getType();
        RootBean rootBean= gson.fromJson(json,type);

        return rootBean;
        }
}
