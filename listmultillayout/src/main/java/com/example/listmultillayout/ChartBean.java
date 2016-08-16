package com.example.listmultillayout;

/**
 * Created by Administrator on 2016/8/11.
 */
public class ChartBean {
    private String  msg;
    private int f;//0表示left，1表示right

    public ChartBean(String msg, int f) {
        this.msg = msg;
        this.f = f;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }
}
