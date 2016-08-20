package com.example.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.sql.PreparedStatement;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase sqLiteDatabase;
    private SqliteOpenDataBase sqliteOpenDataBase;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqliteOpenDataBase = new SqliteOpenDataBase(this);
        listView = ((ListView) findViewById(R.id.listView));
    }

    public void onClick(View view) {
        sqLiteDatabase = sqliteOpenDataBase.getWritableDatabase();
        switch (view.getId()) {
            case R.id.add:
                // sqLiteDatabase.execSQL("insert  into text() values ()");
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", "张三");
                contentValues.put("age", 13);
                contentValues.put("sex", "男");
                long insert = sqLiteDatabase.insert("test", null, contentValues);
                ToastUtil.showToast(this, "已插入数据" + insert + "条");
                break;
            case R.id.delete:
                int delete = sqLiteDatabase.delete("test", "name=?", new String[]{"张三"});
                ToastUtil.showToast(this, "已删除数据" + delete + "条");
                break;
            case R.id.update:
                ContentValues contentValues1 = new ContentValues();
                contentValues1.put("sex", "女");
                contentValues1.put("name", "李四");
                int test = sqLiteDatabase.update("test", contentValues1, "name=?", new String[]{"张三"});
                ToastUtil.showToast(this, "已修改数据" + test + "条");

                break;
            case R.id.select:
              //  Cursor query = sqLiteDatabase.query("test", new String[]{"name", "sex", "age"}, "_id>?", new String[]{"1"}, null, null, null);
             /*   if (query.getCount() != 1) {
                    while (query.moveToNext()) {
                        int name = query.getColumnIndex("name");
                        String columnName = query.getColumnName(name);
                        String string = query.getString(name);
                        ToastUtil.showToast(this, "取出信息:" + name + "===" + columnName + "==" + string);
                    }
                } else {
                    query.moveToFirst();
                    int name = query.getColumnIndex("name");
                    String columnName = query.getColumnName(name);
                    String string = query.getString(name);
                    ToastUtil.showToast(this, "1取出信息:" + name + "===" + columnName + "==" + string);
                }*/
                Cursor query = sqLiteDatabase.query("test", null, null, null, null, null, null);
                //  Cursor query1 = sqLiteDatabase.query("test", new String[]{"name", "sex", "_id"}, "_id>?", new String[]{"1"}, null, null, null);
               MyCursorAdapter myCursorAdapter = new MyCursorAdapter(this, query, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
                // SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.item_list, query, new String[]{"age", "name", "sex"}, new int[]{R.id.id, R.id.name, R.id.sex, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER});
                listView.setAdapter(myCursorAdapter);
               // query.close();
                break;
            case R.id.fragment:

                ItemPart1 itemPart1=new ItemPart1();
                ItemPart2 itemPart2=new ItemPart2();
               getSupportFragmentManager().beginTransaction().replace(R.id.container, itemPart1).commit();

                getSupportFragmentManager().beginTransaction().replace(R.id.container,itemPart2).commit();

                break;

        }
        sqLiteDatabase.close();
    }
}
