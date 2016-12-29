package com.example.gee.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gee on 12/28/2016.
 */

public class FoodDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Food.db";
    public static final String TABLE_NAME="food_table";
    public static final String col_0="ID";
    public static final String col_1="NAME";
    public static final String col_2="CALORIES";
    public static final String col_3="CATEGORY";

    public FoodDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CALORIES INTEGER,CATEGORY TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean addNewFood(String name,String calories,String category){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_1,name);
        contentValues.put(col_2,calories);
        contentValues.put(col_3,category);
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
