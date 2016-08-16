package com.example.xianghaapp.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.example.xianghaapp.model.base.BaseModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


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
                FileOutputStream fos = null;
                try {
                Bitmap image = BitmapFactory.decodeByteArray(bs, 0, bs.length);
                imageView.setImageBitmap(image);
                File externalCacheDir = imageView.getContext().getExternalCacheDir();
                File file=new File(externalCacheDir,PATH.replaceAll("/","")+".jpg");

                     fos = new FileOutputStream(file);
                    //1
                   // image.compress(Bitmap.CompressFormat.JPEG,100,fos);
                    //2
                    fos.write(bs,0,bs.length);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {

                    try {
                        if (fos!=null)
                            fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
