package com.blogspot.abzuxcode.androidlanjutan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends MyFunction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bukaGmail(View view) {
        bukaAcctivity(GmailActivity.class);
    }

    public void bukaSms(View view) {
        bukaAcctivity(SmsActivity.class);
    }

    public void bukaRs(View view) {
        bukaAcctivity(RsActivity.class);
    }

    public void bukaTts(View view) {
        bukaAcctivity(TtsActivity.class);
    }

    public void bukaCamera(View view) {
        bukaAcctivity(CameraActivity.class);
    }
}
