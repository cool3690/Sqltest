package com.grade3.sqltest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Nextpage extends AppCompatActivity {
    Globalfunc func;
    TextView textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpage);
        /*
        Intent intent = this.getIntent();
        Bundle bundle=intent.getExtras();
        String test1 = bundle.getString("test");

         */
        func = new Globalfunc(getApplicationContext());
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
         func.mytoast("eer");

        String code="AA123-1234+12345";
        String qty=code.substring(code.indexOf("+")+1);
        String no=code.substring(0,code.indexOf("+"));
        textView2.setText(no);//只出現此行而已
        textView3.setText(qty);
       // func.mytoast(qty);


    }

}
