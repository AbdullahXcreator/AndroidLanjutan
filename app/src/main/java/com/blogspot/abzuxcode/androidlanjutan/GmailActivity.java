package com.blogspot.abzuxcode.androidlanjutan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

public class GmailActivity extends AppCompatActivity {

    @BindView(R.id.edtsubject)
    EditText edtsubject;
    @BindView(R.id.edtaddress)
    EditText edtaddress;
    @BindView(R.id.edtmassage)
    EditText edtmassage;
    @BindView(R.id.btnkirim)
    FancyButton btnkirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail);
        ButterKnife.bind(this);
    }



    @OnClick(R.id.btnkirim)
    public void onViewClicked() {
        //subject dan email tujuan tidak boleh kosong
        if (TextUtils.isEmpty(edtsubject.getText().toString())) {
            edtsubject.setError(getString(R.string.subject_kosong));
            edtsubject.requestFocus();
        } else if (TextUtils.isEmpty(edtaddress.getText().toString())) {
            edtaddress.setError(getString(R.string.email_tujuan_kosong));
        } else {
            //kirim email menggunakan intent untuk membuka aplikasi email
            Intent intent = new Intent(Intent.ACTION_SEND);
            //buat intent membawa data pada aplikasi
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{edtaddress.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT, edtsubject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, edtmassage.getText().toString());
            //mengubah tipe dari email
            intent.setType("massage/rrfc822");
            //mulai mengirim email ke aplikasi gmail
            startActivity(intent.createChooser(intent, "Pilih Aplikasi"));
        }
    }
}
