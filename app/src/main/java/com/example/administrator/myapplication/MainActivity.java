package com.example.administrator.myapplication;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setBackgroundColor(Color.RED);
        tv1.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tv1.getLayoutParams();
        layoutParams.gravity=Gravity.CENTER;
        layoutParams.topMargin=50;
        tv1.setPadding(0,100,0,0);
        tv1.setFontFeatureSettings(ACTIVITY_SERVICE);
        setVisible(false);
        tv1.setTextSize(60);
        Drawable drawable =getResources().getDrawable(R.mipmap.ic_launcher);//获取一个 drawable
     //  tv1.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher,null,null,null);
        tv1.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable,null,null,null);//设置文字周围的图片
       tv1.setMaxLines(1);
        tv1.setText("asdaaaaaaaaaasdgfhjklkjhgfwtryuiopoiuytrezcxvm,.,mnbvasdfghjktrewrtyu");
        tv1.setText(R.string.aa);
        tv1.setTextColor(Color.BLUE);
       // tv1.setHeight(200);

    }
}
