package com.example.xianghaapp.util;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;

import com.example.xianghaapp.app.AppContext;
import com.example.xianghaapp.model.base.BaseModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/10.
 */
public class UtilAsync extends AsyncTask<String,Void,byte[]> {
   private BaseModel.OnLoadCompleteListener onLoadCompleteListener;
    private ProgressDialog progressDialog;
   private  String PATH;
    public UtilAsync(BaseModel.OnLoadCompleteListener onLoadCompleteListener) {
        this.onLoadCompleteListener = onLoadCompleteListener;

    }

    public UtilAsync(BaseModel.OnLoadCompleteListener onLoadCompleteListener, ProgressDialog progressDialog) {
        this.onLoadCompleteListener = onLoadCompleteListener;
        this.progressDialog = progressDialog;
    }

    /**
     *剩余容量
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public long countAvailableStock(){

        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long availableBlocksLong = statFs.getAvailableBlocksLong();
        long blockSizeLong = statFs.getBlockSizeLong();
             return availableBlocksLong*blockSizeLong;
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public String counAllStock(){

        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long availableBlocksLong = statFs.getTotalBytes();
        String s = Formatter.formatFileSize(AppContext.contex, availableBlocksLong);
        return s;
    }    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
    /**
     * 判断图片是否有缓存
     *
     * @param path
     * @return
     */
    public static boolean isHavaCache(String path) {
        String name = path.replaceAll("/", "");//替换地址
        //创建File 对象
        File file = new File(AppContext.contex.getExternalCacheDir(), name + ".jpg");
        boolean b = isMount();
        boolean b1 = file.exists();
        return isMount() && file.exists();
    }

    public static boolean isMount() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static boolean isSharePreference(){
        SharedPreferences sp=AppContext.contex.getSharedPreferences("noPic", Context.MODE_PRIVATE);
        boolean isNoPic = sp.getBoolean("isNoPic", false);
           return isNoPic;
    }

    /**
     *
     * @param strings
     * @return
     */
    @Override
    protected byte[] doInBackground(String... strings) {
          PATH=strings[0];
        //判断是否有缓存
        //cancel(isHavaCache(PATH)&&isMount());

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
           // throw new RuntimeException("IO异常！========");

        }
        return null;
    }
    @Override
    protected void onPostExecute(byte[] bytes) {
        if (progressDialog!=null){
            progressDialog.dismiss();
        }
        if (bytes!=null&&onLoadCompleteListener!=null) {
            onLoadCompleteListener.onLoadComplete(bytes,PATH);
        }
    }
}
