package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/18.
 */
public class ItemPart1 extends Fragment implements View.OnClickListener {
    private View view;
   // private Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("自定义标签", "onCreate() called with: " + "savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            return view;
        }
        Log.e("自定义标签", "类名==ItemPart1" + "方法名==onCreateView=====:" + "");
        view = inflater.inflate(R.layout.item_part1, container, false);
        LinearLayout viewById = (LinearLayout) view.findViewById(R.id.container1);
        // button = (Button) view.findViewById(R.id.tv1);
        Button  button=new Button(getActivity());
        button.setText("添加fragment2");
        button.setOnClickListener(this);
        viewById.addView(button);
        return view;
    }

    public ItemPart1() {

        super();
        Log.e("自定义标签", "类名==ItemPart1" + "方法名==ItemPart1=====:" + "");
    }

    @Override
    public void onStart() {
        Log.e("自定义标签", "ItemPart1() called with: " + "onStart");
        super.onStart();
    }

    public void onClick(View view) {
        //switch (view.getId()) {
          //  case R.id.tv1:
                ItemPart2 itemPart2 = new ItemPart2();
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,itemPart2).commit();
                //getChildFragmentManager().beginTransaction().replace(R.id.container1,itemPart2).commit();
              getChildFragmentManager().beginTransaction().replace(R.id.container1,itemPart2).commit();
               // break;
       // }
    }

    @Override
    public void onResume() {
        Log.e("自定义标签", "ItemPart1() called with: " + "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("自定义标签", "ItemPart1() called with: " + "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("自定义标签", "ItemPart1() called with: " + "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.e("自定义标签", "类名==ItemPart1" + "方法名==onDestroy=====:" + "");
        super.onDestroy();
    }


}
