package com.example.mvphelloworld.model;

/**
 * Created by Administrator on 2016/8/10.
 */
public interface BaseModel {
       public void loadData(OnLoadCompleteListener onLoadCompleteListener, String path);
       public  interface OnLoadCompleteListener{
           public void onLoadComplete(byte[] bs, String PATH);
       }
}
