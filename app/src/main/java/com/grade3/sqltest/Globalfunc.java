package com.grade3.sqltest;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class Globalfunc {
    Context mContext;

    // constructor
    public Globalfunc(Context context){
        this.mContext = context;
    }

    public void mytoast(String str) {
        Toast toast;
        toast = Toast.makeText(mContext, str, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
