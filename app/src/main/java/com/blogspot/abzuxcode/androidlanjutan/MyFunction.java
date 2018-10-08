package com.blogspot.abzuxcode.androidlanjutan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MyFunction extends AppCompatActivity {

    public Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    public void bukaAcctivity(Class activityTujuan){
        startActivity(new Intent(this,activityTujuan));
    }
}
