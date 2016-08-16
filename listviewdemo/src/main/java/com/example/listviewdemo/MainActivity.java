package com.example.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private List<String> list;
    private List<NewsBean> newsBeanList;
    private DataAdapter dataAdapter;
    private String path = "http://m.mydrivers.com/app/newslist.aspx?%20tid=0&minId=0&maxId=0&ver=2.2&temp=1464423764091";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
       /* list=new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("listView 数据"+i);
        }
        ArrayAdapter<String>  arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        lv.setAdapter(arrayAdapter);*/
        newsBeanList = new ArrayList<>();

        new LoadTask(new LoadTask.DealDataArray() {
            @Override
            public void dealDataArray(byte[] data) {
                if (data != null) {
                    try {
                        //得到数据源了
                        JSONArray jsonArray = new JSONArray(new String(data));//创建Json对象
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.optJSONObject(i);
                            NewsBean newsBean = new NewsBean();
                            int id = jsonObject.getInt("id");
                            newsBean.setId(id);
                            newsBean.setContent(jsonObject.getInt("Content"));
                            newsBean.setDesc(jsonObject.getString("desc"));
                            newsBean.setEditor(jsonObject.getString("editor"));
                            newsBean.setIcon(jsonObject.getString("icon"));
                            newsBean.setPostdate(jsonObject.getString("postdate"));
                            newsBean.setTitle(jsonObject.getString("title"));
                            newsBean.setReviewcount(jsonObject.getInt("reviewcount"));
                            newsBeanList.add(newsBean);
                        }

                        //完全获取数据源
                        dataAdapter = new DataAdapter(newsBeanList);
                        lv.setAdapter(dataAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).execute(path);

    }
}
