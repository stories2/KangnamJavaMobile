package com.mobilecompute.jex2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity {

    CheckBox checkEnable, checkClickable, checkRotate;
    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitLayout();
    }

    public void InitLayout() {
        checkEnable = (CheckBox) findViewById(R.id.checkEnable);
        checkClickable = (CheckBox) findViewById(R.id.checkClickable);
        checkRotate = (CheckBox) findViewById(R.id.checkRotate);

        btnTest = (Button) findViewById(R.id.btnTest);
    }
}
