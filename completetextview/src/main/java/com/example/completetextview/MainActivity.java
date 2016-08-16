package com.example.completetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @FibAnnotation(R.id.et1)
    private EditText et1;
    @FibAnnotation(R.id.at1)
    private AutoCompleteTextView  at1;
    private ArrayAdapter<String>  arrayAdapter;
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            this.getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        FibExplain.fibExplain(this);
        list.add("asdsa");
        //String[] books = new String[] { "rollen", "rollenholt", "rollenren", "roll" };
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        at1.setAdapter(arrayAdapter);
        at1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        at1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onItemSelected=====:" +at1.getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    public void save(View v){

        //list.add(et1.getText().toString());
        arrayAdapter.add(et1.getText().toString());
    }
}
