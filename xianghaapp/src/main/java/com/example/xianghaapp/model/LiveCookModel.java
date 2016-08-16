package com.example.xianghaapp.model;

import android.app.ProgressDialog;

import com.example.xianghaapp.app.AppContext;
import com.example.xianghaapp.model.base.BaseModel;
import com.example.xianghaapp.util.UtilAsync;

/**
 * Created by Administrator on 2016/8/13.
 */
public class LiveCookModel  implements BaseModel {
    @Override
    public void loadData(OnLoadCompleteListener onLoadCompleteListener, String path) {
        ProgressDialog progressDialog=new ProgressDialog(AppContext.contex,ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("这是标题");
        progressDialog.setMax(100);
        progressDialog.setTitle("正在加载中......");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        progressDialog.setCancelable(true);
        progressDialog.setProgress(100);
        new UtilAsync(onLoadCompleteListener,progressDialog).execute(path);
    }
}
