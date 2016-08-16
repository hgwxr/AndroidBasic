package com.example.listappdemo.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/8/9.
 */
public class MeiShiReCaiCallBack  implements MeiShiJieReCaiTask.DealByte {

    private ImageView imageView;

    public MeiShiReCaiCallBack(ImageView imageView) {
        this.imageView = imageView;
    }


    @Override
    public void dealByte(byte[] bytes,String requestPath ) {
        //数据加载完成时
        if (bytes != null) {
            String path= (String) imageView.getTag();//先要的地址
            if (path != null && path.equals(requestPath)) {//比较图片的地址和想要的地址是不是一样的
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
