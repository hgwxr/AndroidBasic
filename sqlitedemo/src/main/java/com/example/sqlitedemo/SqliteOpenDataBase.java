package com.example.sqlitedemo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/8/17.
 */
public class SqliteOpenDataBase extends SQLiteOpenHelper {
    private static final int version = 1;
    private static String name = "test.db";

    public SqliteOpenDataBase(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = " create table test(_id integer primary key autoincrement,name varchar(20),age integer,sex varchar(2) check(sex='男'  or sex='女'));";
        sqLiteDatabase.execSQL(sql);
        //sqLiteDatabase.execSQL("create table person (_id integer primary key autoincrement,name text,age integer,gender text check(gender ='男' or gender ='女'));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
