package com.example.button;

import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/8/2.
 */
public class ButtonClick implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + v.getId()+"=="+v.getParent());
    }
}
