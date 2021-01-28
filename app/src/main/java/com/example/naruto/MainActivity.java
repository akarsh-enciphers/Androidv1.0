package com.example.naruto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button b1,b2;
TextView v2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     b1=(Button)findViewById(R.id.b1);
     b2=(Button)findViewById(R.id.b2);
     e1=(EditText)findViewById(R.id.e1);
     e2=(EditText)findViewById(R.id.e2);
     v2=(TextView)findViewById(R.id.textView2);

     b2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent i=new Intent(MainActivity.this,MainActivity2.class);
             startActivity(i);
             finish();
         }
     });
     b1.setOnClickListener(new View.OnClickListener() {
               @Override
         public void onClick(View v) {
      String s1=e1.getText().toString();
      String s2=e2.getText().toString();
      if (s1.equals("")||s2.equals(""))
      {
          Toast.makeText(MainActivity.this, "please fill all the entries", Toast.LENGTH_SHORT).show();
      }
          else
      {
          SQLiteDatabase db=openOrCreateDatabase("mahadev",MODE_PRIVATE,null);
          db.execSQL("create table if not exists maa(name varchar,email varchar,phone varchar,password varchar)");
          String s3="select * from maa where name='"+s1+"'and password='"+s2+"'";
          Cursor cursor=db.rawQuery(s3,null);
          if(cursor.getCount()>0)
          {
              Toast.makeText(MainActivity.this, "logged in successfully", Toast.LENGTH_SHORT).show();
              Intent j=new Intent(MainActivity.this,MainActivity3.class);
              startActivity(j);
              finish();
          }
          else{
              Toast.makeText(MainActivity.this, "Sorry user not found", Toast.LENGTH_SHORT).show();
              Intent k=new Intent(MainActivity.this,MainActivity2.class);
              startActivity(k);
              finish();
          }
      }
         }
     });
    }
}