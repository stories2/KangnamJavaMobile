package com.mobilecompute.jex2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import static com.mobilecompute.jex2.Settings.DefineManager.DISABLE;
import static com.mobilecompute.jex2.Settings.DefineManager.LOG_LEVEL_INFO;
import static com.mobilecompute.jex2.Settings.DefineManager.ROTATE_DEGREE_0;
import static com.mobilecompute.jex2.Settings.DefineManager.ROTATE_DEGREE_45;
import static com.mobilecompute.jex2.Utils.LogManager.PrintLog;

public class MainActivity extends Activity {

    CheckBox checkEnable, checkClickable, checkRotate;
    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitLayout();

        checkEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean enable) {
                PrintLog("MainActivity", "onCreate/onCheckedChanged", "enable event accepted: " + enable, LOG_LEVEL_INFO);
                btnTest.setEnabled(enable);
            }
        });

        checkClickable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean enable) {
                PrintLog("MainActivity", "onCreate/onCheckedChanged", "clickable event accepted: " + enable, LOG_LEVEL_INFO);
                btnTest.setClickable(enable);
            }
        });

        checkRotate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean enable) {
                PrintLog("MainActivity", "onCreate/onCheckedChanged", "rotate event accepted: " + enable, LOG_LEVEL_INFO);
                if(enable) {
                    btnTest.setRotation(ROTATE_DEGREE_45);
                }
                else {
                    btnTest.setRotation(ROTATE_DEGREE_0);
                }
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintLog("MainActivity", "onCreate/onClick", "test button clicked", LOG_LEVEL_INFO);
            }
        });
    }

    public void InitLayout() {

        PrintLog("MainActivity", "InitLayout", "init layout items", LOG_LEVEL_INFO);

        checkEnable = (CheckBox) findViewById(R.id.checkEnable);
        checkClickable = (CheckBox) findViewById(R.id.checkClickable);
        checkRotate = (CheckBox) findViewById(R.id.checkRotate);

        btnTest = (Button) findViewById(R.id.btnTest);

        btnTest.setEnabled(DISABLE);
        btnTest.setClickable(DISABLE);

        PrintLog("MainActivity", "InitLayout", "init ok", LOG_LEVEL_INFO);
    }
}
