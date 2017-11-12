package com.mobile.jex10;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    RadioGroup radioGroupAnimal;
    final String TAG = "JEX10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupAnimal = (RadioGroup) findViewById(R.id.radioGroupAnimal);
    }

    public void BtnOnPictureShowClick(View view) {

        switch (radioGroupAnimal.getCheckedRadioButtonId()) {
            case R.id.radioDog:
                Log.d(TAG, "picture show: dog");
                break;
            case R.id.radioCat:
                Log.d(TAG, "picture show: cat");
                break;
            case R.id.radioRabbit:
                Log.d(TAG, "picture show: rabbit");
                break;
            case R.id.radioHorse:
                Log.d(TAG, "picture show: horse");
                break;
            default:
                Log.d(TAG, "picture show: default");
                break;
        }
    }
}
