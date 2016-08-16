package com.example.xianghaapp.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public class JsonRootBean {

    private  String res;
    private List<Data> data;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
