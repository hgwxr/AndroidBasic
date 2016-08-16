package com.example.mvphelloworld.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mvphelloworld.presenter.BasePresenter;

/**
 * Created by Administrator on 2016/8/10.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity  {
    private T basePresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter=getBasePresenter();
    }
    public abstract  T  getBasePresenter();
}
