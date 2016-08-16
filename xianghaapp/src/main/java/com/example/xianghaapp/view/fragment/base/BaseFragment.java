package com.example.xianghaapp.view.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.xianghaapp.R;
import com.example.xianghaapp.presenter.base.BasePresenter;
import com.example.xianghaapp.view.base.BaseView;

/**
 * Created by Administrator on 2016/8/13.
 */
public abstract class BaseFragment<T  extends BasePresenter>  extends Fragment {

    protected T basePresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter=getBasePresenter();
    }

    public abstract  T  getBasePresenter();
}
