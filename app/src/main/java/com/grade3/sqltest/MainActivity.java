package com.grade3.sqltest;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.InputType;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    List<String> list;
    String [] g1=new String[2];
    ListView listview;
    List<Boolean> listShow;    // 這個用來記錄哪幾個 item 是被打勾的

    private EditText acc,acc2;
    Button btn,btn1,btn2;
    ImageView imageView;
    String mycart="",account="",names="",passwd="",s="",r="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());

        acc=(EditText)findViewById(R.id.acc);
        acc2=(EditText)findViewById(R.id.acc2);

        btn=(Button)findViewById(R.id.btn);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        imageView=(ImageView)findViewById(R.id.imageView);
        Bitmap bmp = null;
        try {
            URL url = new URL("https://akkyschool.com/images/banner02.jpg");
            // http://web0204.byethost17.com/image/t02.png
           bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {}
        imageView.setImageBitmap(bmp);

        btn.setOnClickListener(btnlogin);
        /*   */
        DragFloatActionButton mBtn = findViewById(R.id.img_btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        listview = (ListView) findViewById(R.id.listview);
        listShow = new ArrayList<Boolean>();
        list = new ArrayList<String>();
        for(int x=1;x<3;x++)
        {
            list.add("項目"+x+"\n"+"aaa"+"\n"+"oiygn");
            listShow.add(true);
        }
        RateAdapter adapterItem = new RateAdapter(this, list);
        listview.setAdapter(adapterItem);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                        {
                                            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
                                            {
                CheckedTextView chkItem = (CheckedTextView) v.findViewById(R.id.check1);
                chkItem.setChecked(!chkItem.isChecked());
                Toast.makeText(MainActivity.this, "您點選了第 "+(position+1)+" 項", Toast.LENGTH_SHORT).show();
                listShow.set(position, chkItem.isChecked());
                }
                                        }
        );
        GlobalVariable gv = (GlobalVariable)getApplicationContext();
        g1[0]="2w";
        g1[1]="2wwwww";
       gv.setPart(g1);
        //acc.setInputType(InputType.TYPE_NULL);
        acc.setOnTouchListener(accbtn);
        btn1.setOnClickListener(btn12);
        btn2.setOnClickListener(btn12);

    }
    private EditText.OnTouchListener accbtn=new EditText.OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent motionEvent) {
            v.onTouchEvent(motionEvent);
            InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
            return true;
        }
    };

    private Button.OnClickListener btn12=new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:

                    if(acc.isFocused()){
                        s=s+"cat";
                        acc.setText(s);
                    }else if(acc2.isFocused()){
                        r=r+"cat";
                        acc2.setText(r);
                    }

                    break;

                case R.id.btn2:

                    if(acc.isFocused()){
                        s=s+"apple";
                        acc.setText(s);
                    }else if(acc2.isFocused()){
                        r=r+"apple";
                        acc2.setText(r);
                    }

                    //same problem .....
                    break;


            }

        }
    };
    private Button.OnClickListener btnlogin=new Button.OnClickListener(){


        public void onClick(View v){
            Intent intent =new Intent(MainActivity.this,Nextpage.class);
            startActivity(intent);
            /*
            String account=acc.getText().toString();
            String result =dblogin.executeQuery(account);
            try{
                JSONArray jsonArray = new JSONArray(result);

                for(int i = 0; i < jsonArray.length(); i++)
                {	 JSONObject jsonData = jsonArray.getJSONObject(i);
                    String email=jsonData.getString("email");
                    Intent intent= new Intent();//轉跳另一頁，並顯示帳密及信箱
                    startActivity(intent);
                }
            }
            catch(Exception e){}
             */

        }
    };
    // 要離開前檢查哪些 item 是打勾的
    @Override
    public void onBackPressed()
    {
        for(int x=0;x<listShow.size();x++)
        {
            if(listShow.get(x)==true){}

        }

    }
    private void mytoast(String str)
    {
        Toast toast=Toast.makeText(this, str, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
