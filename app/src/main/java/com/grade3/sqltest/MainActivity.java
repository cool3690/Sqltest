package com.grade3.sqltest;

import android.accounts.Account;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.View;
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

    private EditText acc;
    Button btn;
    ImageView imageView;
    String mycart="",account="",names="",passwd="";

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

        btn=(Button)findViewById(R.id.btn);
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


    }

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
