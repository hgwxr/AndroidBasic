package com.example.activitypassdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TextView) findViewById(R.id.tv);
          Intent  intent=getIntent();
          tv.setText(intent.getIntExtra("a",-1)+intent.getIntExtra("b",-1)+"");


    }
    public   void rData(View   v){

        Intent  intent=new Intent();
        intent.putExtra("data",tv.getText());
        setResult(RESULT_OK,intent);
        finish();;

    }

}
