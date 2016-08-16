package com.example.button;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @FibAnnotation(R.id.tv1)
    private  TextView tv1;
    @FibAnnotation(R.id.tv2)
    private TextView  tv2;
    @FibAnnotation(R.id.tv3)
    private TextView  tv3;
    @FibAnnotation(R.id.tv4)
    private TextView  tv4;
    @FibAnnotation(R.id.et1)
    private EditText  et1;
    @FibAnnotation(R.id.et2)
    private  EditText et2;
    @FibAnnotation(R.id.im1)
    private ImageView im1;
    @FibAnnotation(R.id.im2)
    private ImageView im2;
    //private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            this.getSupportActionBar().hide();
        }
      //  this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.zonghe);

        FibExplain.fibExplain(this);
//        tv1= (TextView) findViewById(R.id.tv1);
//        tv2= (TextView) findViewById(R.id.tv2);
//        tv3= (TextView) findViewById(R.id.tv3);
//        tv4= (TextView) findViewById(R.id.tv4);
//        im1= (ImageView) findViewById(R.id.im1);
//        im2= (ImageView) findViewById(R.id.im2);
//         et1 = (EditText) findViewById(R.id.et1);
//        et2 = (EditText) findViewById(R.id.et2);
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
         im1.setImageDrawable(drawable);
        im2.setImageDrawable(drawable);
    }



    public void cancel(View v){
           et1.setText("");
           et2.setText("");
           tv4.setText("");
    }
    @TargetApi(Build.VERSION_CODES.M)
    public void printOut(View v) {



        tv4.setText(et1.getText().toString()+"\n"+et2.getText().toString());

        Log.e("自定义标签", "类名==MainActivity 当前环境路径" +Environment.getExternalStorageDirectory().getAbsolutePath()+"||"+im1.getTransitionName()+im1.getAccessibilityClassName()+ "方法名==onClick=====:" + R.id.lin1+"=="+ ((ViewGroup) v.getParent()).getId()+"=="+v.getId());
    }
}
