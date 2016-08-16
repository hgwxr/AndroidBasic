package com.example.mvphelloworld.presenter;

import com.example.mvphelloworld.model.BaseModel;
import com.example.mvphelloworld.model.MainActivityModel;
import com.example.mvphelloworld.model.bean.RootBean;
import com.example.mvphelloworld.util.JsonToBean;
import com.example.mvphelloworld.view.BaseView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/10.
 */
public class BasePresenter<V extends BaseView,T extends BaseModel> {

   private BaseModel baseModel;
    private BaseView  baseView;

    public BasePresenter(BaseView baseView) {
        this.baseView=baseView;
        baseModel=new MainActivityModel();
    }
  private WeakReference<V> weakReference;
    public void attach(V v){
        //通过若引用与activity建立联系
        weakReference=new WeakReference<V>(v);
    }
    public void deattach(){
        if (weakReference!=null){
            weakReference.clear();;
            weakReference=null;
        }
    }
    public V  getView(){

        if (weakReference!=null){
            return  weakReference.get();
        }
          return null;
    }
    public void loadData(final String path){

           baseModel.loadData(new BaseModel.OnLoadCompleteListener() {
               @Override
               public void onLoadComplete(byte[] bs, String PATH) {
                 if (bs!=null) {
                     RootBean rootBean = JsonToBean.getBeanJson(new String(bs));
                     baseView.showData(rootBean.getObj().getData());//回调给activity数据
                 }
               }
           },path);


    }


}
