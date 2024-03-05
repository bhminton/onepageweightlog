package com.example.onepageweightlog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {




    public static final String weight_Table = "WEIGHT_TABLE";
    public static final String column_ID = "ID";
    public static final String column_Weight = "DAILY_WEIGHT";

     SQLiteDatabase bobRobbins;




    public DBHelper(@Nullable Context context) {
        super(context, "bobRobbins.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase bobRobbins) {
        String createTable =  "CREATE TABLE  "
                + weight_Table + "  ( " + column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
               // + column_ID + " TEXT,  "
                + column_Weight + " TEXT  )";
        bobRobbins.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(DailyLog dailyLog) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(column_Weight, dailyLog.getWeight());
        long insert = database.insert(weight_Table, null, cv);

        if (insert == -1) {
            return false;
        } else {
            return true;

        }
    }

    public List<DailyLog> getEverything(){
         List<DailyLog> returnList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String queryString= "SELECT * FROM " + weight_Table;
        Cursor cursor = database.rawQuery(queryString,null);

        if (cursor.moveToFirst()){

            do {

                int   ID   = cursor.getInt(0);
                String weight = cursor.getString(1);

                DailyLog dailyLog= new DailyLog(weight);

                returnList.add(dailyLog);

            } while(cursor.moveToNext());

        } else{
            System.out.println("this is what happens when cursor doesnt work");

        }
        cursor.close();
        database.close();

        return returnList;
    }

}
