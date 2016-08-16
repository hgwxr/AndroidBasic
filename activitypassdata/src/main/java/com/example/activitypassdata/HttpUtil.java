package com.example.activitypassdata;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/6.
 */
public class HttpUtil {


    public static void getPic(final String imgPath, final DealImage dealImage) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn = getConnection(imgPath);
                long contentLengthLong = getContentLength(conn);
                InputStream inputStream = getInputStream(conn);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                long downLength = 0;
                int len;
                byte[] data = new byte[1024 * 2];

                try {
                    while ((len = inputStream.read(data)) != -1) {

                        downLength += len;
                        stream.write(data, 0, len);
                        //可已处理每次下载的数据
                        dealImage.dealImage(data);
                        //进度条
                        dealImage.progressBar(downLength, contentLengthLong);
                    }
                    //读取完，关闭文件流
                    inputStream.close();

                    dealImage.dealImage(stream.toByteArray());
                } catch (IOException e) {
                    throw new RuntimeException("文件流读取异常！");
                }
            }
        }).start();


    }

    private static InputStream getInputStream(HttpURLConnection conn) {
        InputStream inputStream = null;
        try {
            inputStream = conn.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputStream == null) {
            throw new RuntimeException("文件流为空");
        }
        return inputStream;
    }

    private static long getContentLength(HttpURLConnection conn) {
        long contentLengthLong = -1;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            contentLengthLong = conn.getContentLengthLong();
        }
        if (contentLengthLong == -1) {
            throw new RuntimeException("获取文件大小异常！");
        }
        return contentLengthLong;
    }

    private static HttpURLConnection getConnection(String imgPath) {
        try {
            URL url = new URL(imgPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(3000);
            conn.setConnectTimeout(3000);
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return conn;
            } else return null;
        } catch (MalformedURLException e) {
            throw new RuntimeException("url 创建失败！");
        } catch (IOException e) {
            throw new RuntimeException("打开connection失败！");
        }
    }

    public interface DealImage {
        public void dealImage(byte[] data);

        public void progressBar(long currentLength, long contentLenth);
    }
}
