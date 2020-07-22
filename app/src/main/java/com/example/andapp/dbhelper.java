package com.example.andapp;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.SequenceInputStream;
public class dbhelper extends SQLiteOpenHelper {
    Context c;
    public static final String databasename ="appdata";
    public static  final int databaseversion= 6;
    public dbhelper (Context c){
      super(c,databasename,null,databaseversion);
      this.c=c;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
      String sql1="create table user("+
              "_id integer primary key autoincrement ,"
              +" email varchar(40) , "
              +"password varchar(30) ,"
              +"confirm varchar(30) , "
              +"phone varchar(11) )";
      String sql2="create table clinic("+
                "_id integer primary key autoincrement ,"
                +"name varchar(50) , "
                +"email varchar(50) , "
                +"password varchar(30) ,"
                +"confirm varchar(30) , "
                +"department varchar(30),"
                +"phone varchar(11), "
                +"address varchar(30),"
                +"timestart double(10),"
                + "timeend double(10) )";
              db.execSQL(sql1);
              db.execSQL(sql2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
         db.execSQL(" drop table if exists  clinic ");
         onCreate(db);
    }
}
