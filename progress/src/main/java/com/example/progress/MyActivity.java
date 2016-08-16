package com.example.progress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2016/8/4.
 */
public class MyActivity extends Activity {
    public MyActivity() {
        super();
        Log.i("自定义标签", "MyActivity:"+"初始化");
    }

    @Override
    protected void onRestart() {

        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("自定义标签", "onResume:");
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("自定义标签", "onCreate:");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);

    }

    @Override
    protected void onPause() {
        Log.i("自定义标签", "onPause:");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("自定义标签", "onStop:");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("自定义标签", "onDestroy:");
        super.onDestroy();
    }
}
