package com.example.activitypassdata;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements HttpUtil.DealImage {


    private EditText et1;
    private EditText et2;
    private TextView tv1;

    private ProgressBar  pgb;
    private EditText picPath;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv1 = (TextView) findViewById(R.id.tv1);
          picPath = (EditText) findViewById(R.id.et1);
        //pgb= ((ProgressBar) findViewById(R.id.pb));

//        Uri  uri= Uri.parse("tel:1008611");
//        Intent  intent=new Intent(Intent.ACTION_DIAL,uri);
//        startActivity(intent);
//        Uri uri = Uri.parse("tel:1008611");
//        Intent intent = new Intent(Intent.ACTION_CALL, uri);
//
//
//        startActivity(intent);
    }


   public  void getPic(View v){

         String imgPath=picPath.getText().toString().trim();

         HttpUtil.getPic(imgPath,this);

   }

  public void passData(View  v){

      Intent  intent=new Intent(this,Main2Activity.class);

       intent.putExtra("a",Integer.parseInt(et1.getText().toString()));
       intent.putExtra("b",Integer.parseInt(et2.getText().toString()));
//      Bundle bundle = new Bundle();
//        bundle.putString("name", "猴哥");
//        bundle.putString("yulu","老板,老板,有一百个面包圈吗");
//        intent.putExtras(bundle);


      startActivityForResult(intent,100);
  }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100&&resultCode==RESULT_OK){
            tv1.setText(data.getStringExtra("data"));
        }
    }


    @Override
    public void dealImage(final byte[] data) {
         runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 //展示图片
                 Bitmap bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
                 iv.setImageBitmap(bitmap);
             }
         });
    }

    @Override
    public void progressBar(final long currentLength, final long contentLenth) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(currentLength==contentLenth)

                {
                    tv1.setText("下载完成");
                }

                else

                {
                    tv1.setText("下载进度:" + currentLength + "/" + contentLenth);
                }
            }
        });
    }
}
