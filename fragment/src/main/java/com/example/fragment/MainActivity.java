package com.example.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ItemPart1 itemPart1 = new ItemPart1();
    private ItemPart2 itemPart2 = new ItemPart2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fragment:
                getSupportFragmentManager().beginTransaction().addToBackStack(itemPart1.getClass().getSimpleName()).replace(R.id.container, itemPart1).commit();
                break;
            case R.id.fragment2:
                getSupportFragmentManager().beginTransaction().addToBackStack(itemPart2.getClass().getSimpleName()).replace(R.id.container, itemPart2).commit();
                break;
        }
    }

}
