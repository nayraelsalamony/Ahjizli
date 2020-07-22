package com.example.andapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class clinicregesterActivity extends AppCompatActivity {
    dbhelper dphelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicregester);
        dphelp =new dbhelper(getApplicationContext());
    }
    public void gotologin(View V){
        EditText editTextclinicname=findViewById(R.id.clinicname);
        EditText editTextclinicemail=findViewById(R.id.clinicemail);
        EditText editTextclinicpassword=findViewById(R.id.clinicpassword);
        EditText editTextclinicconfirm=findViewById(R.id.clinicconfirm);
        EditText editTextclinicdepartment=findViewById(R.id.clinicdepartment);
        EditText editTextclinicphone=findViewById(R.id.clinicphone);
        EditText editTextclinicaddress=findViewById(R.id.clinicaddress);
        EditText editTextclinictimestart=findViewById(R.id.clinicstarttime);
        EditText editTextclinictimeend=findViewById(R.id.clinicendtime);
        String clinicname=editTextclinicname.getText().toString();
        String clinicemail=editTextclinicemail.getText().toString();
        String clinicpassword=editTextclinicpassword.getText().toString();
        String clinicconfirm=editTextclinicconfirm.getText().toString();
        String clinicdepartment=editTextclinicdepartment.getText().toString();
        String clinicphone= editTextclinicphone.getText().toString();
        String clinicaddress=editTextclinicaddress.getText().toString();
        String clinictimestart=editTextclinictimestart.getText().toString();
        String clinictimeend=editTextclinictimeend.getText().toString();
        SQLiteDatabase db= dphelp.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",clinicname );
        values.put("email",clinicemail );
        values.put("password",clinicpassword);
        values.put("confirm",clinicconfirm );
        values.put("department",clinicdepartment );
        values.put("phone",clinicphone );
        values.put("address",clinicaddress);
        values.put("timestart",clinictimestart );
        values.put("timeend",clinictimeend );
        long rowna=  db.insert("clinic",null,values);
        Toast t=Toast.makeText(getApplicationContext(),rowna+" ",Toast.LENGTH_LONG);
        t.show();
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
