package com.example.user.jex16;

import android.Manifest;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity {

    public static final int ADD_REQUEST_RESULT = 0, MINUS_REQUEST_RESULT = 1, MULTIPLE_REQUEST_RESULT = 2, DIVIDE_REQUEST_RESULT = 3;

    EditText etxtA, etxtB;
    RadioGroup radioGroup;
    int calculateType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Log.v("JEX16", "onCreate");
        //Init1();

        requestPermissions(new String[] {
                Manifest.permission.ACCESS_FINE_LOCATION
        }, MODE_PRIVATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("JEX16", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("JEX16", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("JEX16", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("JEX16", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("JEX16", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("JEX16", "onDestroy");
    }

    public void btnOnEscapeClick(View view) {
        finish();
    }

    public void runIntent(String intentAction, Uri uri) {
        Intent intent = new Intent(intentAction, uri);
        startActivity(intent);
    }

    public void btnOnCallClick(View view) {
        runIntent(Intent.ACTION_DIAL, Uri.parse("tel:010-5635-1845"));
    }

    public void btnOnWebPageClick(View view) {
        runIntent(Intent.ACTION_VIEW, Uri.parse("http://i2max-ml.xyz"));
    }

    public void btnOnGoogleMapClick(View view) {
        runIntent(Intent.ACTION_VIEW, Uri.parse("geo:37,127?z=17"));
    }

    public void btnOnGoogleSearchClick(View view) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "hello world");
        startActivity(intent);
    }

    public void btnOnSendMessageClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra("sms_body", "hello");
        intent.setData(Uri.parse("smsto:" + Uri.parse("010-5635-1845")));
        startActivity(intent);
    }

    public void btnOnPictureClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("content://" + Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/IMG_6994.JPG");
        intent.setDataAndType(uri, "image/jpeg");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case ADD_REQUEST_RESULT:
                    Toast.makeText(getApplicationContext(), "result: " + data.getDoubleExtra("Sum", 0), Toast.LENGTH_SHORT).show();
                    break;
                case MINUS_REQUEST_RESULT:
                    Toast.makeText(getApplicationContext(), "result: " + data.getDoubleExtra("Sum", 0), Toast.LENGTH_SHORT).show();
                    break;
                case MULTIPLE_REQUEST_RESULT:
                    Toast.makeText(getApplicationContext(), "result: " + data.getDoubleExtra("Sum", 0), Toast.LENGTH_SHORT).show();
                    break;
                case DIVIDE_REQUEST_RESULT:
                    Toast.makeText(getApplicationContext(), "result: " + data.getDoubleExtra("Sum", 0), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public void Init1() {

        etxtA = (EditText)findViewById(R.id.etxtA);
        etxtB = (EditText)findViewById(R.id.etxtB);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        calculateType = ADD_REQUEST_RESULT;

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioAdd:
                        calculateType = ADD_REQUEST_RESULT;
                        break;
                    case R.id.radioMinus:
                        calculateType = MINUS_REQUEST_RESULT;
                        break;
                    case R.id.radioMultiple:
                        calculateType = MULTIPLE_REQUEST_RESULT;
                        break;
                    case R.id.radioDivide:
                        calculateType = DIVIDE_REQUEST_RESULT;
                        break;
                }
            }
        });
    }

    public void btnOnAddClick(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        intent.putExtra("A", Integer.parseInt(etxtA.getText().toString()));
        intent.putExtra("B", Integer.parseInt(etxtB.getText().toString()));
        startActivityForResult(intent, ADD_REQUEST_RESULT);
    }

    public void btnOnCalculateClick(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        intent.putExtra("A", Integer.parseInt(etxtA.getText().toString()));
        intent.putExtra("B", Integer.parseInt(etxtB.getText().toString()));
        intent.putExtra("Request", calculateType);
        startActivityForResult(intent, calculateType);
    }
}
