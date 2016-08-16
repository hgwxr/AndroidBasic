package com.example.button;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/8/2.
 */
public class HttpUtil {

      //
    public static void getResource(String path,HandleData handleData){

        try {
            URL  url=new URL(path);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
           if (httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
               InputStream inputStream = httpURLConnection.getInputStream();
               BufferedInputStream  br=new BufferedInputStream(inputStream);
              byte[] data=new byte[1024];
               int len;
               ByteArrayOutputStream  byteArrayOutputStream=new ByteArrayOutputStream();
               while(( len=br.read(data))!=-1){
                   byteArrayOutputStream.write(data,0,len);
               }
           }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   public interface HandleData{

       void handData(byte[] data);

   }
}
