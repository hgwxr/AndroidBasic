package com.example.xianghaapp.util;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/15.
 */
public class ShowView {

    public static void showTextView(View view, Object obj){

        if (view instanceof ImageView){
            ImageView view1 = (ImageView) view;
            String path = String.valueOf(obj);
            view.setTag(path);
            view1.setImageBitmap(null);
            getPic(path, view1);
        }else if (view instanceof TextView){
            view= ((TextView) view);
            ((TextView) view).setText( String.valueOf(obj));
        }

    }
    public static void getPic(String pic, ImageView headerPic) {
        BitMapCallBack bitMapCallBack = new BitMapCallBack(headerPic);
        UtilAsync utilAsync = new UtilAsync(bitMapCallBack);
        utilAsync.execute(pic);
    }
}
