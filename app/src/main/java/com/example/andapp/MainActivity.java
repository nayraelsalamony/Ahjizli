package com.example.andapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  dbhelper dphelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dphelp =new dbhelper(getApplicationContext());

    }
    public void userregister(View V){
        Intent i=new Intent(getApplicationContext(), regesterActivity.class);
        startActivity(i);
    }public void reset(View V){
        Intent i=new Intent(getApplicationContext(), resetpassActivity.class);
        startActivity(i);
    }
    public void login(View V) {
        TextView tv = findViewById(R.id.error);
        EditText editTextname = findViewById(R.id.name);
        String useremail = editTextname.getText().toString();
        EditText editTextpass = findViewById(R.id.pass);
        String pass = editTextname.getText().toString();
        String[] colums = {"email", "password"};
        String selection1 = "email" + " =? ";
        String[] selectionarg1 = {useremail};
        String selection2 = "password" + " =? ";
        String[] selectionarg2 = {pass};
        SQLiteDatabase db = dphelp.getReadableDatabase();
        Cursor cursor1 = db.query("user", colums, selection1, selectionarg1, null, null, null);
        Cursor cursor2 = db.query("user", colums, selection2, selectionarg2, null, null, null);
        if (cursor1 != null&& cursor1.moveToNext()&&cursor2 != null&& cursor2.moveToNext()) {
            Intent i = new Intent(getApplicationContext(), diseasetypeActivity.class);
            startActivity(i);
        }
        else{
            tv.setText("password or user name is not corect");
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
           startActivity(i);
        }
    }
    public void registerasclinic(View v){
        Intent i=new Intent(getApplicationContext(), clinicregesterActivity.class);
        startActivity(i);
    }
}
