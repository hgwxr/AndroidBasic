package com.example.xianghaapp.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xianghaapp.R;
import com.example.xianghaapp.adapter.holder.BaseViewHolder;
import com.example.xianghaapp.app.AppContext;
import com.example.xianghaapp.model.bean.Data;
import com.example.xianghaapp.model.bean.learncookheader.Item_head;
import com.example.xianghaapp.util.BitMapCallBack;
import com.example.xianghaapp.util.UtilAsync;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public class LearnCookAdapter extends UtilBaseAdapter<Data> {
    private List<Data> list;
    private int flag;
    private Item_head item_head;
    public LearnCookAdapter(int id, List<Data> list, int flag, Item_head item_head) {
        super(id, list);
        this.list=list;
        this.flag=flag;
        this.item_head=item_head;
    }

    @Override
    public void fillData(BaseViewHolder bvh, int position) {
        if (flag==0){
        Data data=list.get(position);
        //BaseViewHolder  baseViewHolder=BaseViewHolder.getViewHolder()

        TextView  userShowName= (TextView) bvh.findView(R.id.userShowName);
        userShowName.setText(data.getCustomer().getNickName());
        TextView contentTitle = (TextView) bvh.findView(R.id.contentTitle);
        contentTitle.setText(data.getTitle());
        TextView content = (TextView) bvh.findView(R.id.content);
        content.setText(data.getContent());
        TextView timeGo = (TextView) bvh.findView(R.id.timeGo);
        timeGo.setText(data.getTimeShow()+"."+data.getcName());
        TextView countGood = (TextView) bvh.findView(R.id.countGood);
        countGood.setText("点赞:"+data.getLikeNum());
        TextView numCount = (TextView) bvh.findView(R.id.numCount);
        numCount.setText("评论:"+data.getCommentNum());

        // ImageView headerPic = (ImageView) bvh.findView(R.id.headerPic);
        ImageView headerPic = (ImageView) bvh.findView(R.id.headerPic);
        showPic(data, headerPic);
       if (!UtilAsync.isSharePreference()) {

           List<String> imgs = data.getImgs();

           ImageView im1 = (ImageView) bvh.findView(R.id.im1);
           ImageView im2 = (ImageView) bvh.findView(R.id.im2);
           im1.setImageBitmap(null);
           im2.setImageBitmap(null);
           ImageView[] imageArrays = new ImageView[imgs.size()];
           imageArrays[0]=im1;
           imageArrays[1]=im2;
           int i1 = imgs.size() > 2 ? 2 : 1;
           if (i1==2) {
               ImageView im3 = (ImageView) bvh.findView(R.id.im3);
               im3.setImageBitmap(null);
               imageArrays[2]=im3;
           }

           //判断是否有缓存



           getPic(imgs, imageArrays);
       }else{}

        }else if (flag==1){



        }







    }

    private void showPic(Data data, ImageView headerPic) {
        headerPic.setImageBitmap(null);
        headerPic.setTag(data.getCustomer().getImg());
        getPic(data.getCustomer().getImg(), headerPic);
    }

    private void getPic(String pic, ImageView headerPic) {
        BitMapCallBack bitMapCallBack = new BitMapCallBack(headerPic);
        UtilAsync utilAsync = new UtilAsync(bitMapCallBack);
        utilAsync.execute(pic);
    }
    private void getPic(List<String> pic, ImageView[] headerPic) {

        for (int i = 0; i <headerPic.length ; i++) {
          if (UtilAsync.isMount()&&!UtilAsync.isHavaCache(pic.get(i))) {
              headerPic[i].setTag(pic.get(i));
              BitMapCallBack bitMapCallBack = new BitMapCallBack(headerPic[i]);
              UtilAsync utilAsync = new UtilAsync(bitMapCallBack);
              utilAsync.execute(pic.get(i));
          }else{
              Bitmap bitmap = BitmapFactory.decodeFile(AppContext.contex.getExternalCacheDir() + "/" + pic.get(i).replaceAll("/", "") + ".jpg");
              headerPic[i].setImageBitmap(bitmap);
          }
        }

    }
}
