package com.example.naruto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
Button b1,b2;
TextView v1;
EditText e1,e2,e3,e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editTextTextPersonName);
        e2=(EditText)findViewById(R.id.editTextTextEmailAddress);
        e3=(EditText)findViewById(R.id.editTextPhone);
        e4=(EditText)findViewById(R.id.editTextTextPassword);
        v1=(TextView)findViewById(R.id.textView2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String s1=e1.getText().toString();
            String s2=e2.getText().toString();
            String s3=e3.getText().toString();
            String s4=e4.getText().toString();
            if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                Toast.makeText(MainActivity2.this, "Please fill all the entries", Toast.LENGTH_SHORT).show();
            }
            else{
                SQLiteDatabase db=openOrCreateDatabase("mahadev",MODE_PRIVATE,null);
                db.execSQL("create table if not exists maa(name varchar,email varchar,phone varchar,password varchar)");
                String s5="select * from maa where email='"+s2+"'and phone='"+s3+"' ";
                Cursor cursor=db.rawQuery(s5,null);
                if(cursor.getCount()>0){
                    Toast.makeText(MainActivity2.this, "User already exist", Toast.LENGTH_SHORT).show();
                    Intent j=new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(j);
                    finish();
                }
                else{
                    db.execSQL("insert into maa values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
                    Toast.makeText(MainActivity2.this, "Account made successfully", Toast.LENGTH_SHORT).show();
                    Intent k=new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(k);
                    finish();
                }
            }
            }
        });
    }
}