package com.example.listviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class DataAdapter  extends BaseAdapter {
    private List<NewsBean> newsBeanList;
    public DataAdapter(List<NewsBean> newsBeanList) {
        this.newsBeanList=newsBeanList;
    }

    /**
     * 获取数据源长度
     * @return
     */
    @Override
    public int getCount() {
        return newsBeanList==null ?0:newsBeanList.size();
    }

    /**
     * 获取指定位置的数据源对象，这个方法为手动调用，非 设置适配器时调用
     * @param i  指定的位置
     * @return
     */
    @Override
    public Object getItem(int i) {
        return newsBeanList.get(i);
    }

    /**
     * 获取指定位置的 item  ，标记的id
     * @param i
     * @return
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 工厂方法，返回模板视图，难点，怎么产生一个view，每个视图怎么展示出来，view理怎么放置对应的内容
     * @param i
     * @param view
     * @param parent
     * @return
     */
    @Override
    public View getView(int i, View view, final ViewGroup parent) {

        NewsBean newsBean=newsBeanList.get(i);
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qudong,null);
        final ImageView imageView = (ImageView) view.findViewById(R.id.iv);//图片控件
        new LoadTask(new LoadTask.DealDataArray() {

            @Override
            public void dealDataArray(byte[] bytes) {
                if (bytes != null) {
                    //得到图片了
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    imageView.setImageBitmap(bitmap);
                }else{
                    Toast.makeText(parent.getContext(),"什么破网",Toast.LENGTH_SHORT).show();
                }
            }
        }).execute(newsBean.getIcon());
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView desc = (TextView) view.findViewById(R.id.desc);
        TextView edtor = (TextView) view.findViewById(R.id.edtor);
        TextView count = (TextView) view.findViewById(R.id.count);
        title.setText(newsBean.getTitle());
        desc.setText(newsBean.getDesc());
        edtor.setText(newsBean.getEditor());
        count.setText(newsBean.getReviewcount()+"");
        return view;
    }
}
