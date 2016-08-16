package com.example.listappdemo.task;

import android.os.AsyncTask;

import com.example.listappdemo.Bean.Data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class MeiShiJieReCaiTask extends AsyncTask<String,Void,byte[]>{
    private DealByte dealByte;
    private String path;
    public MeiShiJieReCaiTask(DealByte dealByte) {
        this.dealByte = dealByte;
    }



    @Override
    protected void onPostExecute(byte[] bytes) {
        super.onPostExecute(bytes);
        if (bytes.length!=0){
            dealByte.dealByte(bytes,path);
        }
    }

    @Override
    protected byte[] doInBackground(String... strings) {

        URL  url=null;
        HttpURLConnection httpURLConnection=null;

        try {
            path=strings[0];
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
        }
        return new byte[0];
    }

    public  interface DealByte{
        public void dealByte(byte[] bs,String requestPath);
    }
}
