package com.example.mvphelloworld.util;

import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.example.mvphelloworld.model.BaseModel;

/**
 * Created by Administrator on 2016/8/10.
 */
public class BitMapCallBack   implements BaseModel.OnLoadCompleteListener{
    private ImageView  imageView;

    public BitMapCallBack(ImageView imageView) {
        this.imageView = imageView;
    }


    @Override
    public void onLoadComplete(byte[] bs, String PATH) {
        if (bs!=null) {
            String tag = (String) imageView.getTag();
            if (bs.length != 0 && tag != null && tag.equals(PATH)) {
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(bs, 0, bs.length));
            }
        }
    }
}
