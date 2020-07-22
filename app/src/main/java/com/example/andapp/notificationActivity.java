package com.example.andapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class notificationActivity extends AppCompatActivity {
    dbhelper dphelp;

    ArrayList<String> namelist=new ArrayList<String>();
    ArrayList<String> addresslist=new ArrayList<String>();
    ArrayList<String> phonelist=new ArrayList<String>();
    ArrayList<Double>starttime =new ArrayList<Double>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        dphelp =new dbhelper(getApplicationContext());
       SQLiteDatabase db = dphelp.getReadableDatabase();
       Bundle b =getIntent().getExtras();
     String name=b.getString("name");
        String[] colums = {"name", "address","phone" , "timestart"};
        String selection1 = "name" + " =? ";
        String[] selectionarg1 = {name};
        Cursor cursor = db.query("clinic", colums, selection1, selectionarg1, null, null, null);
        while (cursor != null&& cursor.moveToNext()){
            String  listdoctornames =(cursor.getString(cursor.getColumnIndexOrThrow("name"))) ;
            String  listdoctoraddresss=(cursor.getString(cursor.getColumnIndexOrThrow("address")));
            String  listdoctorphone=(cursor.getString(cursor.getColumnIndexOrThrow("phone")));
            Double  listdoctortimestart =(cursor.getDouble(cursor.getColumnIndexOrThrow("timestart")));
            namelist.add(listdoctornames);
            addresslist.add(listdoctoraddresss);
            phonelist .add(listdoctorphone);
            starttime.add(listdoctortimestart);
        }
        cursor.close();
        TextView tv1= findViewById(R.id.thenameofdoctor);
        tv1.setText(namelist.get(0));
        TextView tv2= findViewById(R.id.theaddressofthedoctor);
        tv2.setText(addresslist.get(0));
        TextView tv3= findViewById(R.id.thephoneofdoctor);
        tv3.setText(phonelist.get(0));
        TextView tv4= findViewById(R.id.thephoneofdoctor);
        tv4.setText(starttime.get(0)+"  am");

      }
    public void notification (View v){
        SQLiteDatabase db1=dphelp.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("timestart" ,starttime.get(0)+0.5 );
        String selection="name";
        String name=namelist.get(0);
        String []selectionargs={name};
        db1.update("clinic",values,selection,selectionargs);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.doctor);
        builder.setContentTitle("reservation confirmation");
        builder.setContentText("reservation is done and time of reservation is :- "+starttime.get(0) +" am");
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1,builder.build());
    }
    }
