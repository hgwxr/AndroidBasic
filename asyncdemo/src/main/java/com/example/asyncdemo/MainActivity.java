package com.example.asyncdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  ImageTask imageTask;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        imageTask=new ImageTask(image);
        //jsontask=new Jsontask<>();
        new MyBaseTask(new Jsontask<List<JsonObject>>() {
            @Override
            public void showData(List<JsonObject> jsonObjects) {

            }


        }).execute();
          //new MyBaseTask(imageTask).execute("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");/**输入参数 在task的doInBackground 方法中可以调用*/
             new MyBaseTask(imageTask).execute("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
          // imageTask.cancel(true);
    }
}
