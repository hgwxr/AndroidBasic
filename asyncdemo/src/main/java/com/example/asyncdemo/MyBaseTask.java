package com.example.asyncdemo;

import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/8.
 */
public class MyBaseTask extends AsyncTask<String, Integer, byte[]> {//参数，progress、过程，返回结果

    private HandlData handlData;

    public MyBaseTask(HandlData handlData) {
        this.handlData = handlData;
    }

    public MyBaseTask() {
        super();
    }

    @Override
    protected void onPreExecute() {
        Log.e("自定义标签", "类名==MyBaseTask" + "方法名==onPreExecute=====:" + "");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        Log.e("自定义标签", "类名==MyBaseTask" + "方法名==onPostExecute=====:" + "");
        super.onPostExecute(bytes);
        if(handlData!=null){
            handlData.handlData(bytes);
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //获取更新的数据
        //可以进行UI操作
        super.onProgressUpdate(values);
        Log.d("自定义标签", "onProgressUpdate() returned: " + values[0]);
    }

    @Override
    protected void onCancelled(byte[] bytes) {
        //取消完成
        super.onCancelled(bytes);
    }

    @Override
    protected void onCancelled() {
        //取消完成
        super.onCancelled();
    }

    @Override
    protected byte[] doInBackground(String... strings) {
        InputStream inputStream = null;
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        //进行耗时操作
        try {
            url = new URL(strings[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int len = 0;
                byte[] data = new byte[1024];
                int  current=0;
                while ((len = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, len);
                    current+=len;
                    publishProgress(current);
                }
                return outputStream.toByteArray();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //如果需要在过程中更新，调用    publishProgress(); 回调 onProgressUpdate()
        //返回数据给
        return new byte[0];
    }

    public interface HandlData {

        public void handlData(byte[] bs);
    }

}
