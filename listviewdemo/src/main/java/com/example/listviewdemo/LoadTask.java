package com.example.listviewdemo;

import android.os.AsyncTask;

/**
 * Created by Administrator on 2016/8/9.
 */
public class LoadTask  extends AsyncTask<String,Void,byte[]> {

    private DealDataArray dealDataArray;

    public LoadTask(DealDataArray dealDataArray) {
        this.dealDataArray = dealDataArray;
    }

    @Override
    protected byte[] doInBackground(String... strings) {
        return HttpUtil.getDataByteArray(strings[0]);
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        super.onPostExecute(bytes);
       dealDataArray.dealDataArray(bytes);
    }
    public interface DealDataArray {
        public void dealDataArray(byte[] data);

        //  public void progressBar(long currentLength, long contentLenth);
    }
}
