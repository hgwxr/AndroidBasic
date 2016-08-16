package com.example.xianghaapp.view;
import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import com.example.xianghaapp.R;
import com.example.xianghaapp.app.AppContext;
import com.example.xianghaapp.util.ToastUtil;
import com.example.xianghaapp.view.fragment.LearnCook;
import com.example.xianghaapp.view.fragment.Message;
import com.example.xianghaapp.view.fragment.Self;
import com.example.xianghaapp.view.fragment.SheQu;
import com.example.xianghaapp.view.fragment.Shop;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private Fragment  fragment;
    private Fragment  lastFragment;
    private LearnCook  learnCook=new LearnCook();
    private  Message message=new Message();
    private Self self=new Self();
    private SheQu sheQu=new SheQu();
    private Shop shop=new Shop();
    private  RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppContext.contex=this;
        super.onCreate(savedInstanceState);
//       if (getSupportActionBar() != null){
//           this.getSupportActionBar().hide();
//       }
        setContentView(R.layout.activity_main);
        rg= ((RadioGroup) findViewById(R.id.rg));
        rg.setOnCheckedChangeListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,learnCook).commit();
        lastFragment=learnCook;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        switch (checkedId){

            case R.id.lean_cook:
                fragment=learnCook;
                //getSupportFragmentManager().beginTransaction().add(R.id.container,learnCook).commit();
                break;
            case R.id.shop:
                //getSupportFragmentManager().beginTransaction().add(R.id.container,shop).commit();
                fragment=shop;
                break;
            case R.id.shequ:
               // getSupportFragmentManager().beginTransaction().add(R.id.container,sheQu).commit();
                fragment=sheQu;
                break;
            case R.id.self:
               // getSupportFragmentManager().beginTransaction().add(R.id.container,self).commit();
                fragment=self;
                break;
            case R.id.message:
                //getSupportFragmentManager().beginTransaction().add(R.id.container,message).commit();
                fragment=message;
                break;

        }
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction().hide(lastFragment);
        if(!fragment.isAdded()){

            fragmentTransaction.add(R.id.container,fragment).commit();

        }else{
            fragmentTransaction.show(fragment).commit();
        }
        lastFragment=fragment;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.item_menu_part1,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch(item.getItemId()){
//            case R.id.changeMenu:
//                ToastUtil.showToast(this,"切换视图");
//                //通知fragment 做出相应的操作
//                break;
//            case R.id.notMenu:
//                ToastUtil.showToast(this,"未开发菜单");
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        //getMenuInflater().inflate(R.menu.item_menu_part1,menu);
//        super.onCreateContextMenu(menu, v, menuInfo);
//
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//
//        switch(item.getItemId()){
//            case R.id.changeMenu:
//                ToastUtil.showToast(this,"切换视图");
//                //通知fragment 做出相应的操作
//                break;
//            case R.id.notMenu:
//                ToastUtil.showToast(this,"未开发菜单");
//                break;
//
//        }
//
//
//        return super.onContextItemSelected(item);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
