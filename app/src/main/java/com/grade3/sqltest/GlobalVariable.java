package com.grade3.sqltest;
import android.app.Application;

import java.util.List;

public class GlobalVariable extends Application {
    private String Account;     //User 名稱

    String[] part;

    public String[] getPart() {
        return part;
    }

    public void setPart(String[] part) {
        this.part = part;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }


}