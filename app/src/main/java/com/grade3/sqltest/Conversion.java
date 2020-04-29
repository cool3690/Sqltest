package com.grade3.sqltest;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Conversion extends AppCompatActivity {
    TextView T1,T2,T3,show;
    EditText Q1,Q2,Q3;
    Button btok;
    int tf=0;
    String word="L";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        T1=(TextView)findViewById(R.id.T1);
        T2=(TextView)findViewById(R.id.T2);
        T3=(TextView)findViewById(R.id.T3);
        show=(TextView)findViewById(R.id.show);
        Q1=(EditText)findViewById(R.id.Q1);
        Q2=(EditText)findViewById(R.id.Q2);
        Q3=(EditText)findViewById(R.id.Q3);
        btok=(Button)findViewById(R.id.btok);
        btok.setOnClickListener(btnok);
        topic();
        setup();

    }
    private Button.OnClickListener btnok=new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
          double ans=0;
          if(!TextUtils.isEmpty(Q1.getText().toString())){
              ans=Double.parseDouble(Q1.getText().toString());
          }


          int ans2=0;
            if(!TextUtils.isEmpty(Q2.getText().toString())){
                ans2=Integer.parseInt(Q2.getText().toString());
            }

          int ans3=0;
            if(!TextUtils.isEmpty(Q3.getText().toString())){
                ans3=Integer.parseInt(Q3.getText().toString());
            }

          if(ans*1000==ans2*1000+ans3)
            {
                setup();
            }
          else{
              mytoast(ans*1000+"    :     "+ans2*1000+ans3);
              //mytoast("wrong");
          }
        }
    };
    public void topic(){
        if(word.equals("K")){
            T1.setText("公斤(kg)");
            T2.setText("公斤(kg)");
            T3.setText("公克(g)");
            show.setText("1公斤(kg)=1000公克(g)"+"\n"+"1公克(g)=0.001公斤(kg)");
        }
        else if(word.equals("L")){
            T1.setText("公升(L)");
            T2.setText("公升(L)");
            T3.setText("毫升(ml)");
            show.setText("1公升(L)=1000毫升(ml)"+"\n"+"1毫升(ml)=0.001公升(L)");
        }
        else if(word.equals("M")){
            T1.setText("公分(cm)");
            T2.setText("毫米(mm)");
            T3.setText("毫升(ml)");
            show.setText("1公分(L)=10毫米(mm)"+"\n"+"1毫米(mm)=0.1公分(cm)");
        }
    }
    public void setup(){
        Q2.setVisibility(View.VISIBLE);
        T2.setVisibility(View.VISIBLE);
        Q1.setText("");
        Q2.setText("");
        Q3.setText("");

        Random random=new Random();
        tf=random.nextInt(4);
        if(tf==0){
            double t=random.nextInt(100);
            t=t/10.0;
            Q1.setText(t+"");
            disableedit(Q1);
            ableedit(Q2);
            ableedit(Q3);
        }
        else if(tf==1){
           int x=random.nextInt(99)+1;
            int y=random.nextInt(999)+1;

            Q2.setText(x+"");
            Q3.setText(y+"");
            ableedit(Q1);
            disableedit(Q2);
            disableedit(Q3);

        }
        else if(tf==2){
            Q2.setVisibility(View.GONE);
            T2.setVisibility(View.GONE);
            int y=random.nextInt(20)+1;
            Q1.setText(y+"");
            disableedit(Q1);
        }
        else if(tf==3){
            Q2.setVisibility(View.GONE);
            T2.setVisibility(View.GONE);
            int y=random.nextInt(20)+1;
            y=y*1000;
            Q3.setText(y+"");
            disableedit(Q3);
        }
    }

  public void disableedit(EditText et)
    {
        et.setEnabled(false);
        et.setBackgroundColor(Color.TRANSPARENT);
    }
    public void ableedit(EditText et)
    {
        et.setEnabled(true);
        et.setFocusable(true);

    }
    private void mytoast(String str)
    {
        Toast toast=Toast.makeText(this, str, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
