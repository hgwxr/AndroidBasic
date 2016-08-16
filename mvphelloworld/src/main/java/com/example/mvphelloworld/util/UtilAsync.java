package com.example.mvphelloworld.util;

import android.os.AsyncTask;

import com.example.mvphelloworld.model.BaseModel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/10.
 */
public class UtilAsync extends AsyncTask<String,Void,byte[]> {
   private BaseModel.OnLoadCompleteListener onLoadCompleteListener;
   private  String PATH;
    public UtilAsync(BaseModel.OnLoadCompleteListener onLoadCompleteListener) {
        this.onLoadCompleteListener = onLoadCompleteListener;

    }

    @Override
    protected byte[] doInBackground(String... strings) {
          PATH=strings[0];
        URL url=null;
        HttpURLConnection httpURLConnection=null;
        try {
            PATH=strings[0];
            url=new URL(strings[0]);
            httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){

                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
                int len=0;
                byte[] data=new byte[1024];
                while((len=inputStream.read(data))!=-1){
                    outputStream.write(data,0,len);
                }
                return outputStream.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("IO异常！========");

        }
        return null;
    }
    @Override
    protected void onPostExecute(byte[] bytes) {
        if (bytes!=null) {
            onLoadCompleteListener.onLoadComplete(bytes,PATH);
        }
    }
}
