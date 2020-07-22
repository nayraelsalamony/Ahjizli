package com.example.andapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class diseasetypeActivity extends AppCompatActivity {
    dbhelper dphelp;
    RadioGroup radioGroup;
    RadioButton rp;
    String namedepart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseasetype);
        dphelp =new dbhelper(getApplicationContext());
        radioGroup=findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb :
                        RadioButton rp=findViewById(R.id.rb);
                        namedepart=rp.getText().toString();
                        break;
                    case R.id.rhraet :
                         rp=findViewById(R.id.rhraet);
                        namedepart=rp.getText().toString();
                        break;
                    case R.id.rgt :
                        rp=findViewById(R.id.rgt);
                        namedepart=rp.getText().toString();
                        break;
                    case R.id.rbaby :
                         rp=findViewById(R.id.rbaby );
                        namedepart=rp.getText().toString();
                        break;
                    case R.id.rtooth  :
                        rp=findViewById(R.id.rtooth);
                        namedepart=rp.getText().toString();
                        break;
                    case R.id.rwoman:
                         rp=findViewById(R.id.rwoman);
                        namedepart=rp.getText().toString();
                        break;
                    case R.id.ries :
                         rp=findViewById(R.id.ries);
                        namedepart=rp.getText().toString();
                        break;
                    case R.id.razam :
                         rp=findViewById(R.id.razam);
                        namedepart=rp.getText().toString();
                        break;
                }
            }
        });

    }
    public void selectdr(View v){
        Intent i=new Intent(getApplicationContext(),bookedActivity.class);
        i.putExtra("dpartmentname",namedepart);
        startActivity(i);
    }
}
