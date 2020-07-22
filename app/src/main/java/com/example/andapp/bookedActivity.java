package com.example.andapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class bookedActivity extends AppCompatActivity {
    dbhelper dphelp;
    ArrayList<String> namelist = new ArrayList<String>();
    ArrayList<String> addresslist = new ArrayList<String>();
    ArrayList<Integer> timestartlist = new ArrayList<Integer>();
    ArrayList<Integer> timeendlist = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
        Bundle b = getIntent().getExtras();
        String s = b.getString("dpartmentname");
        String[] selectionarg1 = {s};
        Integer photo = R.drawable.doctor;
        String[] colums = {"name", "address", " timestart", "timeend"};
        String selection1 = "department" + " =? ";
        dphelp = new dbhelper(getApplicationContext());
        SQLiteDatabase db = dphelp.getReadableDatabase();
        Cursor cursor = db.query("clinic", colums, selection1, selectionarg1, null, null, null);
        while (cursor != null && cursor.moveToNext()) {
            String listdoctornames = (cursor.getString(cursor.getColumnIndexOrThrow("name")));
            String listdoctoraddresss = (cursor.getString(cursor.getColumnIndexOrThrow("address")));
            namelist.add(listdoctornames);
            addresslist.add(listdoctoraddresss);
        }
        cursor.close();
        listviewActivity adpter = new listviewActivity(getApplicationContext(), R.layout.activity_listview, photo, namelist, addresslist);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = findViewById(R.id.thename);
                String name = textView.getText().toString();
                TextView textView2 = findViewById(R.id.theaddress);
                String address = textView2.getText().toString();
                Intent i = new Intent(getApplicationContext(), notificationActivity.class);
                i.putExtra("name", name);
                i.putExtra("address", address);
                startActivity(i);

            }
        });

    }


}
