package com.example.xianghaapp.presenter.base;



import com.example.xianghaapp.model.base.BaseModel;
import com.example.xianghaapp.view.base.BaseView;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/8/10.
 */
public abstract class BasePresenter<V extends BaseView> {

   protected BaseModel baseModel;
    protected BaseView  baseView;

    public BasePresenter(BaseView baseView) {
        this.baseView=baseView;
        //baseModel=new MainActivityModel();
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
    //public abstract void loadData(final String path);


}
