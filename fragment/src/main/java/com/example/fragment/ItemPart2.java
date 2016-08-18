package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/8/18.
 */
public class ItemPart2 extends Fragment implements View.OnClickListener{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_part2, container, false);
        LinearLayout viewById = (LinearLayout) view.findViewById(R.id.container2);
        // button = (Button) view.findViewById(R.id.tv1);
        Button button=new Button(getActivity());
        button.setText("添加fragment1");
        button.setOnClickListener(this);
        viewById.addView(button);
        return view;
    }

    @Override
    public void onClick(View view) {
       // switch (view.getId()){
           // case R.id.tv2:
                ItemPart1 itemPart1=new ItemPart1();
                getFragmentManager().beginTransaction().replace(R.id.container2,itemPart1).commit();
              //  break;
       // }
    }
}
