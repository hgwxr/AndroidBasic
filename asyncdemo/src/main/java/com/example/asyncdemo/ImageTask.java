package com.example.asyncdemo;

import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/8/8.
 */
public class ImageTask  implements   MyBaseTask.HandlData {
    private ImageView image;

    public ImageTask( ImageView image) {

        this.image = image;
    }

    @Override
    public void handlData(byte[] bs) {
          //处理数据，在请求成功后
        image.setImageBitmap(BitmapFactory.decodeByteArray(bs,0,bs.length));
    }
}
