package com.example.gee.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gee on 12/17/2016.
 */

public class MemberDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Member.db";
    public static final String TABLE_NAME="member_table";
    public static final String col_0="ID";
    public static final String col_1="NAME";
    public static final String col_2="EMAIL";
    public static final String col_3="PASSWORD";
    public static final String col_4="BIRTHDAY";
    public static final String col_5="GENDER";


    public MemberDataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,PASSWORD TEXT,BIRTHDAY TEXT,GENDER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean addNewMember(String name,String email,String password,String birthday,String gender){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_1,name);
        contentValues.put(col_2,email);
        contentValues.put(col_3,password);
        contentValues.put(col_4,birthday);
        contentValues.put(col_5,gender);
        long result=db.insert(TABLE_NAME,null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
