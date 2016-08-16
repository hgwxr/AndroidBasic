package com.example.dongtaiview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
       // LayoutInflater.from(this).inflate(R.layout.item_part)
       // LinearLayout linLayout = (LinearLayout) findViewById(R.id.rLayout);
      //  ViewGroup viewGroup = (ViewGroup) linLayout.getParent();
       // View inflate = LayoutInflater.from(this).inflate(R.layout.item_part, viewGroup, true);
       // linLayout.addView(inflate);
        LinearLayout linLayout= (LinearLayout) LayoutInflater.from(this).inflate(R.layout.activity_main,null);
      //  LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      //  View view = inflater.inflate(R.layout.item_part, null);
        View view = getLayoutInflater().inflate(R.layout.item_part, null);
        linLayout.addView(view);
        View view1 = getLayoutInflater().inflate(R.layout.item_part, null);
        linLayout.addView(view1);
        setContentView(linLayout);
    }
}
