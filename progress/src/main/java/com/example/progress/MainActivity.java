package com.example.progress;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar   sb;
    private TextView tv;
    private Button bt1;
    private LinearLayout ll1;
    private ScrollView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);
        Intent  intent=new Intent();
          setIntent(intent);
         //Utils.getDaa("http://skycnxz2.wy119.com//2/wifiwannengyaoshi.apk",sb,tv);
        // sb= (ProgressBar) findViewById(R.id.sb);



//                bt1 = (Button) findViewById(R.id.bt2);
//               ll1= ((LinearLayout) findViewById(R.id.ll1));
//              //  ll1.removeView(bt1);
//     for(int i=0;i<10;i++){
//         Button b=new Button(this);
//            b.setText("添加按钮"+i);
//            b.setWidth(200);
//            b.setBackgroundColor(Color.RED);
//              ll1.addView(b);}
               // sv= ((ScrollView) findViewById(R.id.sv1));
//        for(int i=0;i<10;i++){
//            TextView textView = new TextView(this);
//            textView.setTextSize(30);
//            textView.setText("这是代码创建的"+i);
//            textView.setTextColor(Color.RED);
//            //lin.addView(textView);
////
//            ll1.addView(textView);
            //this.add(textView);
      //  }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void add(View v){
//        for(int i=0;i<50;i++){
////            TextView textView = new TextView(this);
////            textView.setTextSize(30);
////            textView.setText("这是代码创建的");
////            textView.setTextColor(Color.RED);
//            //lin.addView(textView);
//            Button b=new Button(this);
//            b.setText("添加按钮"+i);
//            b.setWidth(200);
//            b.setBackgroundColor(Color.RED);
//            ll1.addView(b);
//              //this.add(textView);
//        }
//        Notification.Builder  builder=new Notification.Builder(this);
//        builder.setContentTitle("赵日天");
//        builder.setContentText("正文");
//        builder.setTicker("尼玛 ，赵日天来消息了！")
//                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
//                .setAutoCancel(true)  ;                         //设置点击后取消Notification
//        NotificationManager  manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        manager.notify(1,builder.build());
        Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
    }
}
