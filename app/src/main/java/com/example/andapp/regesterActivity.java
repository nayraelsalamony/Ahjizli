package com.example.andapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class regesterActivity extends AppCompatActivity {
    dbhelper dphelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regester);
        dphelp =new dbhelper(getApplicationContext());
    }
    public void dologin(View V){
        EditText editTextname=findViewById(R.id.useremail);
        EditText editTextpassword=findViewById(R.id.userpassword);
        EditText editTextconfirm=findViewById(R.id.userconfirm);
        EditText editTextphone=findViewById(R.id.userphone);
        String useremail=editTextname.getText().toString();
        String userpassword=editTextpassword.getText().toString();
        String usereconfirm=editTextconfirm.getText().toString();
        String userphone=editTextphone.getText().toString();
        SQLiteDatabase db= dphelp.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email",useremail );
        values.put("password",userpassword );
        values.put("confirm",usereconfirm);
        values.put("phone",userphone );
        long rowna=  db.insert("user",null,values);
        Toast t=Toast.makeText(getApplicationContext(),rowna+" ",Toast.LENGTH_LONG);
        t.show();
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
