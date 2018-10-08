package com.blogspot.abzuxcode.androidlanjutan;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

class SmsActivity extends AppCompatActivity {
    @BindView(R.id.edsSmsTo)
    EditText edsSmsTo;
    @BindView(R.id.edSmsPesan)
    EditText edSmsPesan;
    @BindView(R.id.btnSmsIntent)
    FancyButton btnSmsIntent;
    @BindView(R.id.btnSmsKirim)
    FancyButton btnSmsKirim;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSmsIntent)
    public void onBtnSmsIntentClicked() {
        //cek apakah data input kosong
        if (TextUtils.isEmpty(edsSmsTo.getText().toString())){
            edsSmsTo.setError(getString(R.string.pilih_nomor));
            edsSmsTo.requestFocus();
        }else if (TextUtils.isEmpty(edSmsPesan.getText().toString())) {
            edSmsPesan.setError(getString(R.string.masukan_pesan));
            edSmsPesan.requestFocus();
        }else {
            //membuka aplikasi sms menggunakan intent
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra("Sms_body", edSmsPesan.getText().toString());
            intent.putExtra("Sms_to", edsSmsTo.getText().toString());
            intent.setType("vnd.android-dir/mms-sms");
            startActivity(intent.createChooser(intent, getString(R.string.pilih_aplikasi)));
        }
    }

    @OnClick(R.id.btnSmsKirim)
    public void onBtnSmsKirimClicked() {
        //kirim langsung pesan dari aplikasi
        //cek permission
        //jika permission pada pengaturan untuk apikasi ini belum enable
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_DENIED) {
            //tampilkan massage minta izin
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 120);
        } else{
            //kirim sms langsung
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(edsSmsTo.getText().toString(),
                        null,edSmsPesan.getText().toString(),
                        null,null);

                clearForm();
                Toast.makeText(this, getString(R.string.mrngirim), Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(this, getString(R.string.gagal_mrngirim), Toast.LENGTH_SHORT).show();
            }
        }


    }

    private void clearForm() {
        edsSmsTo.setText("");
        edSmsPesan.setText("");
    }
}
