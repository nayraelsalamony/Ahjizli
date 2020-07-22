package com.example.andapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class resetpassActivity extends AppCompatActivity {
    dbhelper dphelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpass);
        dphelp =new dbhelper(getApplicationContext());
    }
    public void relogin(View v){
       EditText editTextname=findViewById(R.id.resetuseremail);
        EditText editTextpassword=findViewById(R.id.resetpass);
        String useremail=editTextname.getText().toString();
        String userpassword=editTextpassword.getText().toString();
        SQLiteDatabase db=dphelp.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("password" ,userpassword );
        String selection="email=?";
        String []selectionargs={useremail};
        db.update("user",values,selection,selectionargs);
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
