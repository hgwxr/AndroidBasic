package com.example.sqlitedemo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/17.
 */
public class MyCursorAdapter  extends CursorAdapter {
    public MyCursorAdapter(Context context, Cursor c, int autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_list,null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView age = (TextView) view.findViewById(R.id.sex);
        int nameIndex = cursor.getColumnIndex("name");//通过列名找到列的索引
        int ageIndex = cursor.getColumnIndex("sex");
        String nameString = cursor.getString(nameIndex);//获取到对应列的内容
        String ageString = cursor.getString(ageIndex);
        name.setText(nameString);
        age.setText(ageString);
    }
}
